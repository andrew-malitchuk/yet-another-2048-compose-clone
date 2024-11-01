package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game

import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toRepository
import dev.ya2048cc.domain.usecase.core.model.game.GridDomainModel
import dev.ya2048cc.domain.usecase.source.usecase.game.RestartUseCase

class RestartUseCaseImpl(
    private val gameRepository: GameRepository
) : RestartUseCase {
    override suspend fun invoke() {
        with(gameRepository) {
            val current = getData()?.toDomain()?: GameDomainModel(GridDomainModel(4))
            current.grid.current = mutableListOf()
            repeat(current.grid.size) {
                current.grid.current.add(IntArray(current.grid.size) { 0 })
            }
            repeat(current.grid.size / 2) {
                current.grid.addTile()
            }
            updateData(current.toRepository())
        }
    }

}