package dev.ya2048cc.data.preference.source.datasource

import dev.ya2048cc.data.preference.core.model.ScorePreferenceModel
import dev.ya2048cc.data.preference.source.datasource.base.BasePreferenceDataSource
import kotlinx.coroutines.flow.Flow

interface ScorePreferenceDataSource: BasePreferenceDataSource<ScorePreferenceModel> {
    override fun subscribeToData(): Flow<ScorePreferenceModel>
    override suspend fun updateData(value: ScorePreferenceModel?)
    override suspend fun getData(): ScorePreferenceModel?
}