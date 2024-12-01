package dev.ya2048cc.presentation.feature.game.source.navigation.direction

import kotlinx.serialization.Serializable

@Serializable
sealed class GameDirection {
    @Serializable
    data object Game : GameDirection()
}
