@file:Suppress("DSL_SCOPE_VIOLATION")
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.muhammetkudur.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val apiKey = gradleLocalProperties(rootDir).getProperty("API_KEY")
        buildConfigField("String", "API_KEY", apiKey)
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    
    buildFeatures{
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:domain"))

    //android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    //test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // MockWebServer
    testImplementation(libs.mockwebserver)
    // Truth
    testImplementation(libs.truth)
    // Mockito
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.inline)
    // Turbine
    testImplementation(libs.turbine)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    //Paging
    implementation(libs.androidx.paging.runtime.ktx)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)

    //OkHttp
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
}