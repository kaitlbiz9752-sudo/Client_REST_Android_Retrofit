plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ma.projet.restclient"
    compileSdk = 34

    defaultConfig {
        applicationId = "ma.projet.restclient"
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            pickFirst("META-INF/NOTICE.md")
            pickFirst("META-INF/LICENSE.md")
            pickFirst("META-INF/DEPENDENCIES")
            pickFirst("META-INF/NOTICE")
            pickFirst("META-INF/LICENSE")
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    
    // Retrofit & Converters
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    
    implementation("com.squareup.retrofit2:converter-simplexml:2.9.0") {
        exclude(group = "xpp3", module = "xpp3")
        exclude(group = "stax", module = "stax-api")
        exclude(group = "stax", module = "stax")
    }
    
    implementation("org.simpleframework:simple-xml:2.7.1") {
        exclude(group = "xpp3", module = "xpp3")
        exclude(group = "stax", module = "stax-api")
        exclude(group = "stax", module = "stax")
    }

    implementation("com.squareup.retrofit2:converter-jaxb:2.9.0") {
        exclude(group = "javax.xml.bind", module = "jaxb-api")
        exclude(group = "javax.activation", module = "javax.activation-api")
    }
    
    // JAXB API & Runtime for Android
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:2.3.3") {
        exclude(group = "jakarta.activation", module = "jakarta.activation-api")
    }
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.3") {
        exclude(group = "jakarta.activation", module = "jakarta.activation-api")
    }

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}