package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game

import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.source.usecase.game.IsGameWonUseCase


class IsGameWonUseCaseImpl(
    private val gameRepository: GameRepository,
) : IsGameWonUseCase {
    override suspend fun invoke(): Boolean {
        val grid = gameRepository.getData()?.toDomain()?.grid
        grid ?: return false
        for (i in grid.current.indices)
            for (j in grid.current.indices) {
                if (grid.current[i][j] == 2048) {
                    return true
                }
            }
        return false
    }
}