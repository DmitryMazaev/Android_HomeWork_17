plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.android_homework_17"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.android_homework_17"
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
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.10.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.10.0")
    // https://mvnrepository.com/artifact/com.squareup.moshi/moshi
    implementation("com.squareup.moshi:moshi:1.15.0")
    implementation("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    // Skip this if you don't want to use integration libraries or configure Glide.
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
    runtimeOnly("androidx.recyclerview:recyclerview:1.3.2")
}