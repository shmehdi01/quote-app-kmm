import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    //DI HILT
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    //VIEW MODEL LIFECYCLE
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.activity:activity-ktx:1.3.1")
    implementation ("androidx.fragment:fragment-ktx:1.4.0-alpha09")

    //COMPOSE
    // Integration with activities
    implementation ("androidx.activity:activity-compose:1.3.1")
    // Compose Material Icons
    implementation ("androidx.compose.material:material-icons-extended:1.1.1")
    // Compose Material Design
    implementation ("androidx.compose.material:material:1.0.1")
    // Animations
    implementation ("androidx.compose.animation:animation:1.0.1")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-tooling:1.0.1")
    // Integration with ViewModels
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    // UI Tests
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.0.1")
    //Navigation
    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha09")

}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "app.shmehdi.quote.android"
        minSdkVersion(21)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }
}

