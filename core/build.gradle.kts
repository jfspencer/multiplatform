import com.core.config.DependenciesPlugin.Companion.androidCompileVersion
import com.core.config.DependenciesPlugin.Companion.androidMinSdk
import com.core.config.DependenciesPlugin.Companion.androidTargetSdk
import com.core.config.DependenciesPlugin.Companion.kTorVersion
import com.core.config.DependenciesPlugin.Companion.koinVersion
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    //id("kotlinx-serialization")
    id("com.core.config.dependencies")
    id("org.jetbrains.kotlin.js") apply false
}

kotlin {
    android()

    js(IR) {
        moduleName = "CoreKMM"
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
                outputFileName = "core.js"
                showProgress = true
            }
            webpackTask {
                outputFileName = "mycustomfilename.js"
                output.library = "CoreKMM"
            }
        }
        binaries.executable()
    }

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "core"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                //Ktor
                implementation("io.ktor:ktor-client-core:$kTorVersion")

                //Koin
                implementation("io.insert-koin:koin-core:$koinVersion")
                //implementation("io.insert-koin:koin-ktor:$koinVersion")
            }
        }
        val commonTest by getting {
            dependencies {

//                implementation(kotlin("test-common"))
//                implementation(kotlin("test-annotations-common"))
//
//                //Ktor
//                implementation("io.ktor:ktor-client-mock:$kTorVersion")
//
//                //Koin
//                implementation("io.insert-koin:koin-test:$koinVersion")
//                implementation("io.insert-koin:koin-test-junit5:$koinVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                //Koin
                implementation("io.insert-koin:koin-androidx-workmanager:$koinVersion")
                implementation("io.insert-koin:koin-androidx-compose:$koinVersion")

                //Ktor
                implementation("io.ktor:ktor-client-android:$kTorVersion")
            }
        }
        val androidTest by getting {
            dependencies {
//                implementation(kotlin("test-junit"))
//                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:$kTorVersion")
            }
        }
        val iosTest by getting

        val jsMain by getting {
            dependencies {
                //implementation("io.ktor:ktor-client-js:$kTorVersion")
            }
        }
        val jsTest by getting
    }
}

android {
    compileSdk = androidCompileVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = androidMinSdk
        targetSdk = androidTargetSdk
    }
}