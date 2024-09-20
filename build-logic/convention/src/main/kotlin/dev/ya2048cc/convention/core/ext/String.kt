package dev.ya2048cc.convention.core.ext

import org.gradle.api.plugins.PluginManager


/**
 * Well, you can define plugin by using `+`. Why not?
 *
 * @receiver PluginManager
 * @receiver String
 *
 * ```
 * plugins {
 *      +"io.gitlab.arturbosch.detekt"
 * }
 * ```
 */
context(PluginManager)
operator fun String.unaryPlus() {
    apply(this)
}

///**
// * Suppress some lint rule
// *
// * @receiver Lint
// * @receiver String
// *
// * ```
// * lint {
// *      -"TypographyFractions"
// * }
// * ```
// */
//context(Lint)
//operator fun String.unaryMinus() {
//    disable.add(this)
//}
