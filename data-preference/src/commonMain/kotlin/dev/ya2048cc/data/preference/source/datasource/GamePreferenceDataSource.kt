package dev.ya2048cc.data.preference.source.datasource

import dev.ya2048cc.data.preference.core.model.GamePreferenceModel
import dev.ya2048cc.data.preference.source.datasource.base.BasePreferenceDataSource
import kotlinx.coroutines.flow.Flow

interface GamePreferenceDataSource: BasePreferenceDataSource<GamePreferenceModel> {
    override fun subscribeToData(): Flow<GamePreferenceModel>
    override suspend fun updateData(value: GamePreferenceModel?)
    override suspend fun getData(): GamePreferenceModel?
}