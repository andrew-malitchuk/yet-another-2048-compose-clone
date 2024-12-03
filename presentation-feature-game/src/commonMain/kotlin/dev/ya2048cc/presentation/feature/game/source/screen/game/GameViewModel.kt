package dev.ya2048cc.presentation.feature.game.source.screen.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ya2048cc.domain.usecase.core.model.SwipeDomainModel
import dev.ya2048cc.domain.usecase.source.usecase.game.GetGameUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.NewGameUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.RestartUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.SwipeScenario
import dev.ya2048cc.domain.usecase.source.usecase.move.UndoMoveUseCase
import dev.ya2048cc.domain.usecase.source.usecase.score.GetScoreUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class GameViewModel(
    getScoreUseCase: GetScoreUseCase,
    private val newGameUseCase: NewGameUseCase,
    private val undoMoveUseCase: UndoMoveUseCase,
    private val restartUseCase: RestartUseCase,
    getGameUseCase: GetGameUseCase,
    private val swipeScenario: SwipeScenario,
) : ViewModel(), KoinComponent {

    val game = getGameUseCase()
    val score = getScoreUseCase()

    var isHjklSelect: MutableStateFlow<Boolean> = MutableStateFlow(false)

    fun newGame() {
        viewModelScope.launch {
            newGameUseCase()
            restartUseCase()
        }
    }

    fun undoMove() {
        viewModelScope.launch {
            undoMoveUseCase()
        }
    }

    fun onMove(swipeDomainModel: SwipeDomainModel, foo: List<IntArray>) {
        viewModelScope.launch {
            swipeScenario(swipeDomainModel, foo)
        }
    }

    fun onHjklSelect(isSelected: Boolean) {
        viewModelScope.launch {
            isHjklSelect.emit(isSelected)
        }
    }

}

