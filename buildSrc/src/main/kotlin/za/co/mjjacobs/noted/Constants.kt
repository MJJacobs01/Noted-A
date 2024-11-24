package za.co.mjjacobs.noted

import org.gradle.api.JavaVersion

object Constants {
    //  Namespaces
    const val appNameSpace = "za.co.mjjacobs.noted"

    //  Versions
    const val versionCode = 1
    const val versionName = "1.0.0"     //  Major.Minor.Patch

    const val isMinifyEnabledRelease = true
    const val isMinifyEnabledDebug = false

    val javaVersion = JavaVersion.VERSION_11

    val jvmTarget = "11"
}