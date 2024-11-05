package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.state

import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.data.repository.source.repository.HistoryRepository
import dev.ya2048cc.data.repository.core.model.HistoryRepositoryModel
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.source.usecase.state.SavePreviousStateUseCase

class SavePreviousStateUseCaseImpl(
    private val historyRepository: HistoryRepository,
    private val gameRepository: GameRepository
) : SavePreviousStateUseCase {
    override suspend fun invoke() {
        val currentGame = gameRepository.getData()?.toDomain()
        if (currentGame?.grid?.current == null) {
            currentGame?.grid?.current = mutableListOf()
            repeat(currentGame?.grid?.size ?: 0) {
                currentGame?.grid?.current?.add(IntArray(currentGame.grid.size) { 0 })
            }
        }
        currentGame?.grid?.current ?: return
        with(historyRepository) {
            var current = getData() ?: HistoryRepositoryModel(emptyList())
            current = current.copy(
                previousState = currentGame.grid.current
            )
            updateData(current)
        }
    }
}