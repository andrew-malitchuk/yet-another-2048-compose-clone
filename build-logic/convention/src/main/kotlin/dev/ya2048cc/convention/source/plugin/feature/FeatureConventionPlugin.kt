package dev.ya2048cc.convention.source.plugin.feature

import com.android.build.api.dsl.LibraryExtension
import dev.ya2048cc.convention.core.ext.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.impldep.org.bouncycastle.pqc.crypto.lms.Composer.compose
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * Convention plugin for feature convention
 *
 * commonMainApi (https://github.com/icerockdev/moko-resources)
 */
@Suppress("unused")
class FeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
            apply(libs.findPlugin("jetbrainsCompose").get().get().pluginId)
            apply(libs.findPlugin("androidLibrary").get().get().pluginId)
            apply(libs.findPlugin("compose.compiler").get().get().pluginId)
        }
        with(libs) {
            dependencies {
//                implementDependency("koin.core")
//                implementDependency("koin.android")
//                implementDependency("koin.compose")
            }
        }
        extensions.getByType<KotlinMultiplatformExtension>().apply {
            androidTarget().apply {
                compilations.all {
                    kotlinOptions {
                       jvmTarget = "21"
                    }
                }
            }
//            iosX64() {
//                binaries.framework {
//                    baseName = "presentation-feature-host"
//                    isStatic = true
//                    export("dev.icerock.moko:resources:0.22.3")
//                    export("dev.icerock.moko:graphics:0.9.0")
//                }
//            }
//            iosArm64() {
//                binaries.framework {
//                    baseName = "presentation-feature-host"
//                    isStatic = true
//                    export("dev.icerock.moko:resources:0.22.3")
//                    export("dev.icerock.moko:graphics:0.9.0")
//                }
//            }
//            iosSimulatorArm64() {
//                binaries.framework {
//                    baseName = "presentation-feature-host"
//                    isStatic = true
//                    export("dev.icerock.moko:resources:0.22.3")
//                    export("dev.icerock.moko:graphics:0.9.0")
//                }
//            }

//            sourceSets.apply {
//                getByName("commonMain").dependencies {
//                    implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
//                }
        }

//            extensions.getByType<LibraryExtension>().apply {
//                namespace = "dev.ya2048cc.io.presentation.feature.host"
//                compileSdk = 34
//                defaultConfig {
//                    minSdk = 24
//                }
//                compileOptions {
//                    sourceCompatibility = JavaVersion.VERSION_1_8
//                    targetCompatibility = JavaVersion.VERSION_1_8
//                }
//            }
//        }
    }

}