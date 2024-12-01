package dev.ya2048cc.presentation.feature.game.source.screen.game

import dev.ya2048cc.domain.usecase.core.model.SwipeDomainModel


sealed class GameAction {
    data object NewGameAction : GameAction()
    data object RedoGameAction : GameAction()
    data class OnHjklSelect(val selected: Boolean) : GameAction()
    data object GoToAbout : GameAction()
    data class OnSwipe(val swipe: SwipeDomainModel, val grid: List<IntArray>) : GameAction()
}