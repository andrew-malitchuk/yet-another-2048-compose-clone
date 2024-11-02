package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.move

import dev.ya2048cc.data.repository.source.repository.HistoryRepository
import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.data.repository.source.repository.ScoreRepository
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toRepository
import dev.ya2048cc.domain.usecase.source.usecase.move.UndoMoveUseCase

class UndoMoveUseCaseImpl(
    private val historyRepository: HistoryRepository,
    private val scoreRepository: ScoreRepository,
    private val gameRepository: GameRepository,
) : UndoMoveUseCase {
    override suspend fun invoke() {
        val boardConfiguration = historyRepository.getData()
        boardConfiguration?.previousState?.let {
            var currentGame = gameRepository.getData()?.toDomain()
            currentGame = currentGame?.copy(
                grid = currentGame.grid.copy(
                    current = it as MutableList<IntArray>
                )
            )
            gameRepository.updateData(currentGame?.toRepository())
        }

        with(scoreRepository){
            val currentScore = getData()
            if(currentScore?.previousScore!=0) {
                updateData(
                    currentScore?.copy(
                        score = currentScore.previousScore,
                        previousScore = 0,
                        moves = (currentScore.moves - 1)
                    )
                )
            }
        }
    }
}