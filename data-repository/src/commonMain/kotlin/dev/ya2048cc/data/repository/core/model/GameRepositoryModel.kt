package dev.ya2048cc.data.repository.core.model

import dev.ya2048cc.data.preference.core.model.GamePreferenceModel
import dev.ya2048cc.data.repository.core.mapper.base.BaseRepositoryPreferenceMapper
import dev.ya2048cc.data.repository.core.model.GridRepositoryModel.Companion.toPreference
import dev.ya2048cc.data.repository.core.model.GridRepositoryModel.Companion.toRepository
import dev.ya2048cc.data.repository.core.model.base.BaseRepositoryModel

data class GameRepositoryModel(
    val grid: GridRepositoryModel
) : BaseRepositoryModel {
    companion object : BaseRepositoryPreferenceMapper<GameRepositoryModel, GamePreferenceModel> {
        override fun GameRepositoryModel.toPreference() = GamePreferenceModel(
            grid.toPreference()
        )

        override fun GamePreferenceModel.toRepository() = GameRepositoryModel(
            grid.toRepository()
        )
    }
}