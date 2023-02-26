plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
}
android {
    namespace = "buzz.lnmath.feature"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    debugImplementation(libs.bundles.compose.test)
    implementation(libs.accompanist.pager)
    implementation(libs.kotlinx.collections)
    implementation(libs.coil.kt.compose)
    implementation(project(":core-repository"))
    implementation(project(":feature:statusPage"))
}