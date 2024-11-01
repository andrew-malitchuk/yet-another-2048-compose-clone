package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game

import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.data.repository.source.repository.HistoryRepository
import dev.ya2048cc.data.repository.source.repository.ScoreRepository
import dev.ya2048cc.data.repository.core.model.HistoryRepositoryModel
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toRepository
import dev.ya2048cc.domain.usecase.source.usecase.game.NewGameUseCase

class NewGameUseCaseImpl(
    private val historyRepository: HistoryRepository,
    private val scoreRepository: ScoreRepository,
    private val gameRepository: GameRepository,
) : NewGameUseCase {
    override suspend fun invoke() {
        val current = gameRepository.getData()?.toDomain()
        current?.grid?.current = mutableListOf()
        repeat(current?.grid?.size ?: 0) {
            current?.grid?.current?.add(IntArray(current.grid.size) { 0 })
        }

        historyRepository.updateData(current?.grid?.current?.let { HistoryRepositoryModel(it) })

        gameRepository.updateData(current?.toRepository())
        with(scoreRepository) {
            val current = getData()
            updateData(
                current?.copy(
                    score = 0,
                    moves = 0
                )
            )
        }
    }
}