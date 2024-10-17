package dev.ya2048cc.domain.usecase.core.model

import dev.ya2048cc.data.repository.core.model.GridRepositoryModel
import dev.ya2048cc.domain.usecase.core.mapper.base.BaseDomainRepositoryMapper
import dev.ya2048cc.domain.usecase.core.model.base.BaseDomainModel
import dev.ya2048cc.domain.usecase.core.model.game.GridDomainModel
import dev.yapp.ya2048cc.data.repository.model.ScoreRepositoryModel

data class ScoreDomainModel(
    var score: Int,
    val previousScore: Int,
    val highScore: Int,
    val moves: Int,
) : BaseDomainModel {
    companion object : BaseDomainRepositoryMapper<ScoreDomainModel, ScoreRepositoryModel> {
        override fun ScoreDomainModel.toRepository() = ScoreRepositoryModel(
            score, previousScore, highScore, moves
        )

        override fun ScoreRepositoryModel.toDomain() = ScoreDomainModel(
            score, previousScore, highScore, moves
        )
    }
}