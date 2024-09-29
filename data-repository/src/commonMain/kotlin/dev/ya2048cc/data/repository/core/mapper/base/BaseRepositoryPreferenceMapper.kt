package dev.ya2048cc.data.repository.core.mapper.base

import dev.ya2048cc.data.preference.core.model.base.BasePreferenceModel
import dev.ya2048cc.data.repository.core.model.base.BaseRepositoryModel

interface BaseRepositoryPreferenceMapper<Repository : BaseRepositoryModel, Preference : BasePreferenceModel> {
    fun Repository.toPreference(): Preference
    fun Preference.toRepository(): Repository
}