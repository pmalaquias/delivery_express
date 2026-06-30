plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

configurations.all {
    resolutionStrategy {
        force("androidx.concurrent:concurrent-futures:1.2.0")
    }
}

android {
    namespace = "com.pmalaquias.deliveryexpress"
    compileSdk = 37

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.pmalaquias.deliveryexpress"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "GOOGLE_MAPS_API_KEY", "\"${project.findProperty("API_KEY")}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.maps.compose)
    implementation(libs.play.services.maps)
    implementation(libs.compose.material)
    implementation(libs.gson)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation (libs.lifecycle.runtime.ktx)
    implementation(libs.material3)
    implementation(libs.accompanist.permissions)
    implementation(libs.coil)
    implementation(libs.coil.compose)



    //retrofit
    //retrofit-core
    implementation (libs.retrofit)
    //retrofit-converter-moshi
    implementation (libs.converter.moshi)
    //okhttp
    implementation (libs.logging.interceptor)
    implementation (libs.okhttp)
    //moshi
    implementation (libs.moshi.kotlin)
    implementation(libs.animation)
    implementation(libs.javax.inject)
    implementation(libs.transport.runtime)
    implementation(libs.material)
    implementation(libs.haze)
    implementation(libs.haze.materials)
    testImplementation(libs.kotlinx.coroutines.test)
    implementation (libs.converter.gson)

    val navVersion = "2.8.9"
    val composeVersion = "1.8.0"


    implementation(libs.graphics.core)
    implementation(libs.graphics.path)
    implementation(libs.graphics.shapes)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.navigation.compose)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(libs.compose.bom)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material.icons.extended.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.compose.bom)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
