package dev.ya2048cc.domain.usecase.core.model.game

import dev.ya2048cc.data.repository.core.model.GameRepositoryModel
import dev.ya2048cc.domain.usecase.core.mapper.base.BaseDomainRepositoryMapper
import dev.ya2048cc.domain.usecase.core.model.base.BaseDomainModel
import dev.ya2048cc.domain.usecase.core.model.game.GridDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.core.model.game.GridDomainModel.Companion.toRepository

data class GameDomainModel(
    val grid: GridDomainModel
) : BaseDomainModel {
    companion object : BaseDomainRepositoryMapper<GameDomainModel, GameRepositoryModel> {
        override fun GameDomainModel.toRepository() = GameRepositoryModel(
            grid = grid.toRepository()
        )

        override fun GameRepositoryModel.toDomain() = GameDomainModel(
            grid = this.grid.toDomain()
        )
    }
}