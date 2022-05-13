object Versions {
    const val COMPILE_SDK = 31
    const val MIN_SDK = 24
    const val TARGET_SDK = 31
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
    const val COMPOSE = "1.1.1"
    const val ANDROID_GRADLE_VERSION = "7.4.0-alpha01"
    const val KOTLIN = "1.6.10"
    const val HILT = "2.38.1"
    const val HILT_ANDROID_COMPILER = "2.37"
    const val HILT_VIEW_MODEL = "1.0.0-alpha03"
    const val HILT_COMPILER = "1.0.0"
    const val RETROFIT = "2.9.0"
    const val OKHTTP3 = "3.12.1"
    const val PERMISSIONS = "0.24.7-alpha"
    const val MATERIAL_3 = "1.0.0-alpha10"
    const val ROOM = "2.4.2"
    const val COROUTINES = "1.6.0"
    const val VIEW_MODEL_COMPOSE = "2.4.0-beta01"
    const val NAVIGATION_COMPOSE = "2.4.0-alpha09"
    const val HILT_NAVIGATION_COMPOSE = "1.0.0-alpha03"
    const val ESPRESSO = "3.4.0"
    const val JUNIT_EXT = "1.1.3"
    const val JUNIT = "4.13.2"
    const val ACTIVITY_COMPOSE = "1.3.1"
    const val CORE_KTX = "1.7.0"
    const val LIFECYCLE_RUNTIME = "2.3.1"
    const val COMPOSE_MATERIAL = "1.1.1"
    const val JVM_TARGET = "1.8"
    const val kotlinCompilerExtensionVersion = "1.1.1"
}

object BuildPlugins{
    const val androidGradle = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_VERSION}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
}

object Android{
    const val minSDK = Versions.MIN_SDK
    const val targetSDK = Versions.TARGET_SDK
    const val versionCode = Versions.VERSION_CODE
    const val versionName = Versions.VERSION_NAME
    const val compileSDK = Versions.COMPILE_SDK
    const val applicationId = "com.mohamedfathidev.skindiseasesdiagnosissystem"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Libs{
    const val coreKtx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.COMPOSE_MATERIAL}"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.VIEW_MODEL_COMPOSE}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_COMPOSE}"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.COMPOSE}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION_COMPOSE}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.HILT_ANDROID_COMPILER}"
    const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEW_MODEL}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.HILT_COMPILER}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3}"
    const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.PERMISSIONS}"
    const val material3 = "androidx.compose.material3:material3:${Versions.MATERIAL_3}"
    const val material3Window = "androidx.compose.material3:material3-window-size-class:${Versions.MATERIAL_3}"
    const val room = "androidx.room:room-runtime:${Versions.ROOM}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.ROOM}"
}

object TestLibs{
    const val junit = "androidx.test.ext:junit:${Versions.JUNIT}"
    const val junitExt = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
}

object DebugLibs{
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
}