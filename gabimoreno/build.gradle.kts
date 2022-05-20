plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "soy.gabimoreno"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "${rootProject.extra["version_compose"]}"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":modules:player"))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.compose.ui:ui:${rootProject.extra["version_compose"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["version_compose"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${rootProject.extra["version_compose"]}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")

    implementation(platform("com.google.firebase:firebase-bom:29.2.1"))
    implementation("com.google.firebase:firebase-analytics-ktx")

    implementation("com.google.dagger:hilt-android:${rootProject.extra["version_hilt"]}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra["version_hilt"]}")

    implementation("com.google.android.exoplayer:exoplayer-core:${rootProject.extra["version_exo_player"]}")
    implementation("com.google.android.exoplayer:exoplayer-ui:${rootProject.extra["version_exo_player"]}")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["version_compose"]}")

    debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["version_compose"]}")
}