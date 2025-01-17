package dev.ya2048cc.convention.core.config

import org.gradle.api.JavaVersion

/**
 * Project-level configuration
 */
object ProjectConfig {

    const val APPLICATION_ID = "dev.ya2048cc.app"

    object SDK {
        const val MIN_SDK = 24
        const val TARGET_SDK = 34
        const val COMPILE_SDK = TARGET_SDK
    }

    val JAVA_VERSION = JavaVersion.VERSION_17

    const val KOTLIN_VERSION = "17"
}