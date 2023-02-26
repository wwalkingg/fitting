@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}
val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
android {
    namespace = "buzz.lnmath.template"
    compileSdk = 33

    defaultConfig {
        applicationId = "buzz.lnmath.template"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "0.01"

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
        kotlinCompilerExtensionVersion =   versionCatalog.findVersion("androidxComposeCompiler").get().toString()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.test)
    implementation(libs.koin.core)
    implementation(libs.koin.androidx.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(project(":core-repository"))
    implementation(project(":feature:home"))
}