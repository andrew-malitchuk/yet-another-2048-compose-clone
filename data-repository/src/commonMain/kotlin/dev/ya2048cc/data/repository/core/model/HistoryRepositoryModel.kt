package dev.ya2048cc.data.repository.core.model

import dev.ya2048cc.data.preference.core.model.HistoryPreferenceModel
import dev.ya2048cc.data.repository.core.mapper.base.BaseRepositoryPreferenceMapper
import dev.ya2048cc.data.repository.core.model.base.BaseRepositoryModel

data class HistoryRepositoryModel(
    val previousState: List<IntArray>,
) : BaseRepositoryModel {
    companion object : BaseRepositoryPreferenceMapper<HistoryRepositoryModel, HistoryPreferenceModel> {
        override fun HistoryRepositoryModel.toPreference() = HistoryPreferenceModel(
            previousState = previousState
        )

        override fun HistoryPreferenceModel.toRepository() = HistoryRepositoryModel(
            previousState = previousState
        )
    }
}