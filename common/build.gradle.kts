plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.google.devtools.ksp") version "1.7.21-1.0.8"
    kotlin("plugin.serialization") version "1.7.21"
}

kotlin {
    android()
    jvm("desktop")

    sourceSets {
        named("commonMain") {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(compose.preview)
                implementation(libs.ktorFitLib)
                implementation(libs.koin)
                implementation(libs.ktorNegotiation)
                implementation(libs.ktorSerialization)
                implementation(libs.ktorLogging)
                implementation(libs.koin)
                implementation(libs.coroutinesCore)
                implementation(libs.multiplatformPaging)
                implementation(libs.bundles.paging)

                implementation(libs.kotlinxCoroutinesAndroid)
                implementation(libs.bundles.compose)
                implementation(libs.bundles.lifecycleCompose)
                implementation(libs.coil.compose)
                implementation(libs.bundles.accompanist.pager)
                implementation(libs.bundles.compose.navigastion)
            }
        }
        named("androidMain") {
            dependencies {
                api(libs.appcompat)
                api(libs.coreKtx)
            }
        }
    }
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", libs.kspKtorfit)
    add("kspAndroid", libs.kspKtorfit)
    add("kspDesktop", libs.kspKtorfit)
}
