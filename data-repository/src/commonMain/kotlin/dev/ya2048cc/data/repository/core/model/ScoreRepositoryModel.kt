package dev.yapp.ya2048cc.data.repository.model

import dev.ya2048cc.data.preference.core.model.ScorePreferenceModel
import dev.ya2048cc.data.repository.core.mapper.base.BaseRepositoryPreferenceMapper
import dev.ya2048cc.data.repository.core.model.base.BaseRepositoryModel

data class ScoreRepositoryModel(
    var score: Int,
    val previousScore: Int,
    var highScore: Int,
    var moves: Int,
) : BaseRepositoryModel {
    companion object :
        BaseRepositoryPreferenceMapper<ScoreRepositoryModel, ScorePreferenceModel> {
        override fun ScoreRepositoryModel.toPreference() = ScorePreferenceModel(
            score, previousScore, highScore, moves
        )

        override fun ScorePreferenceModel.toRepository() = ScoreRepositoryModel(
            score, previousScore, highScore, moves
        )
    }
}