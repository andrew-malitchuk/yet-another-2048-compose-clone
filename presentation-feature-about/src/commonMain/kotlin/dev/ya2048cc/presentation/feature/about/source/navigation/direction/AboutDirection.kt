package dev.ya2048cc.presentation.feature.about.source.navigation.direction

import kotlinx.serialization.Serializable

@Serializable
sealed class AboutDirection {
    @Serializable
    data object About : AboutDirection()
}