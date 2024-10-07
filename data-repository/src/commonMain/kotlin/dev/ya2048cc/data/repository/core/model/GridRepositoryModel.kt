package dev.ya2048cc.data.repository.core.model

import dev.ya2048cc.data.preference.core.model.GridPreferenceModel
import dev.ya2048cc.data.repository.core.mapper.base.BaseRepositoryPreferenceMapper
import dev.ya2048cc.data.repository.core.model.base.BaseRepositoryModel

data class GridRepositoryModel(
    val size: Int,
    val current: MutableList<IntArray>,
) : BaseRepositoryModel {

    companion object  : BaseRepositoryPreferenceMapper<GridRepositoryModel, GridPreferenceModel> {
        override fun GridRepositoryModel.toPreference() = GridPreferenceModel(
            size,
            current
        )

        override fun GridPreferenceModel.toRepository() = GridRepositoryModel(
            size,
            current
        )
    }
}