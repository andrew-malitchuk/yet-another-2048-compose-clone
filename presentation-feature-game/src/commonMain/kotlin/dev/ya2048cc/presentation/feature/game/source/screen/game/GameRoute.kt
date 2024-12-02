package dev.ya2048cc.presentation.feature.game.source.screen.game

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.ya2048cc.presentation.core.navigation.source.direction.NavigationDirection
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun GameRoute(
    onTransition: ((NavigationDirection) -> Unit)? = null
) {
    val viewModel: GameViewModel = koinViewModel()

    val game by viewModel.game.collectAsStateWithLifecycle(initialValue = null)
    val scope by viewModel.score.collectAsStateWithLifecycle(initialValue = null)
    val isHjklSelect by viewModel.isHjklSelect.collectAsStateWithLifecycle(initialValue = false)

    GameScreen(
        game = game,
        score = scope,
        isHjklSelect = isHjklSelect,
        modifier = Modifier.padding(),
        onAction = { action ->
            when (action) {
                GameAction.NewGameAction -> viewModel.newGame()
                GameAction.RedoGameAction -> viewModel.undoMove()
                is GameAction.OnHjklSelect -> viewModel.onHjklSelect(action.selected)
                GameAction.GoToAbout -> onTransition?.invoke(NavigationDirection.About)
                is GameAction.OnSwipe -> viewModel.onMove(action.swipe, action.grid)
            }
        }
    )
}