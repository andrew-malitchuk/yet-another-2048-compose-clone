package dev.ya2048cc.convention.core.ext

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

/**
 * Contains reference for `libs.versions.toml`
 *
 * @receiver Project
 */
val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

/**
 * DSL wrapper for simple plugin management
 *
 * @receiver Project
 * @param block lambda body
 *
 * ```
 * plugins {
 *      +"ya2048cc.convention.application"
 * }
 * ```
 */
@Suppress("unused")
fun Project.plugins(block: PluginManager.() -> Unit) {
    this.pluginManager.block()
}

val Project.androidLibs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("androidLibs")
