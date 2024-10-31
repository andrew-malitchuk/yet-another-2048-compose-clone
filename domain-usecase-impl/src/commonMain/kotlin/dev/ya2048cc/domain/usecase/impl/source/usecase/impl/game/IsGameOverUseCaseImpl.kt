package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game

import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.source.usecase.game.IsGameOverUseCase

class IsGameOverUseCaseImpl(
    private val gameRepository: GameRepository,
) : IsGameOverUseCase {
    override suspend fun invoke(): Boolean {
        val grid = gameRepository.getData()?.toDomain()?.grid
        grid ?: return true
        for (i in grid.current.indices)
            for (j in grid.current.indices) {
                if (grid.current[i][j] == 2048) {
                    if (grid.current[i][j] == 0)
                        return false
                    if (i != grid.size - 1 && grid.current[i][j] == grid.current[i + 1][j])
                        return false
                    if (j != grid.size - 1 && grid.current[i][j] == grid.current[i][j + 1])
                        return false
                }
            }
        return false
    }
}