plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.veen.mvvmbase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.veen.mvvmbase"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.viewbinding)
    implementation(libs.androidx.databinding.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    /******** hilt dependencies ***********/
    implementation(libs.android.hilt)
    ksp(libs.dagger.hilt.android.compiler)

    /******** retrofit dependencies ***********/
    implementation(libs.android.retrofit)
    implementation(libs.android.retrofit.converter)
    implementation(libs.android.okhttp)
    implementation(libs.android.okhttp.logging)
    implementation(libs.android.gson)
    implementation(libs.androidx.webkit)

    /******** shared preference dependencies ***********/
    implementation(libs.android.sharedpreference)

    /******** play store update dependencies ***********/
    implementation(libs.android.play.store)

    /******** kotlin ktx dependencies ***********/
    implementation(libs.android.activity)
    implementation(libs.android.lifecycle)
    implementation(libs.android.fragment)
}

