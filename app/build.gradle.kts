import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

// Читаем local.properties
val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) load(file.inputStream())
}

android {
    namespace = "com.example.mobiledv_services"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.mobiledv_services"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Ключи из local.properties в BuildConfig
        buildConfigField("String", "APPMETRICA_API_KEY",
            "\"${localProperties["appmetrica_api_key"] ?: ""}\"")
        buildConfigField("String", "MAPS_API_KEY",
            "\"${localProperties["maps_api_key"] ?: ""}\"")
        buildConfigField("String", "VK_APP_ID",
            "\"${localProperties["vk_app_id"] ?: ""}\"")
        buildConfigField("String", "YANDEX_CLIENT_ID",
            "\"${localProperties["yandex_client_id"] ?: ""}\"")
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    coreLibraryDesugaring(libs.android.desugar.jdk.libs)

    implementation(project(":core"))
    implementation(project(":core:navigation"))
    implementation(project(":core:ui"))
    implementation(project(":habits:ui"))
    implementation(project(":habits:data"))
    implementation(project(":stats:ui"))

    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.fragment.ktx)

    // Задание 1 — AppMetrica аналитика
    implementation(libs.appmetrica.analytics)

    // Задание 2 — VK авторизация
    implementation(libs.vk.sdk.core)
    implementation(libs.vk.sdk.api)

    // Задание 2 — Яндекс авторизация
    implementation(libs.yandex.authsdk)

    // Задание 2 — Безопасное хранение токенов
    implementation(libs.security.crypto)

    // Задание 3 — Яндекс MapKit
    // Задание 3 — Google Maps + геолокация
    implementation(libs.google.maps)
    implementation(libs.google.location)

    testImplementation(libs.junit)
    testImplementation(libs.konsist)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
