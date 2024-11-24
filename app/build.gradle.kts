import za.co.mjjacobs.noted.Constants

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kspPlugin)
    alias(libs.plugins.hilt)
}

android {
    namespace = Constants.appNameSpace
    compileSdk = libs.versions.compileSdk.get().toInt()
    
    defaultConfig {
        applicationId = Constants.appNameSpace
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = Constants.versionCode
        versionName = Constants.versionName
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildTypes {
        release {
            isMinifyEnabled = Constants.isMinifyEnabledRelease
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            applicationIdSuffix = ".release"
        }

        debug {
            isMinifyEnabled = Constants.isMinifyEnabledDebug
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = Constants.javaVersion
        targetCompatibility = Constants.javaVersion
    }
    kotlinOptions {
        jvmTarget = Constants.jvmTarget
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    //  Modules

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //  Unit tests
    testImplementation(libs.junit)

    //  Integration tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    //  Debug tooling
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //  Hilt
    implementation(libs.hiltAndroid)
    ksp(libs.hiltAndroidCompiler)

    // For instrumentation tests
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.compiler)

    // For local unit tests
    testImplementation(libs.hilt.android.testing)
    kspTest(libs.hilt.compiler)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    testImplementation(kotlin("test"))
    androidTestImplementation(kotlin("test"))
    androidTestImplementation(libs.kotlin.test.junit)
}

tasks.withType<Test> {
    useJUnitPlatform()
}