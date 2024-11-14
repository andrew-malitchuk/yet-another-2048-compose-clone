package dev.ya2048cc.presentation.core.navigation.source.direction

@kotlinx.serialization.Serializable
sealed class NavigationDirection {

    @kotlinx.serialization.Serializable
    data object About : NavigationDirection()

    @kotlinx.serialization.Serializable
    data object Game : NavigationDirection()
}
