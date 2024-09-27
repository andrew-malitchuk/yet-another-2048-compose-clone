package dev.ya2048cc.data.preference.source.datasource

import dev.ya2048cc.data.preference.core.model.HistoryPreferenceModel
import dev.ya2048cc.data.preference.source.datasource.base.BasePreferenceDataSource
import kotlinx.coroutines.flow.Flow


interface HistoryPreferenceDataSource: BasePreferenceDataSource<HistoryPreferenceModel> {
    override fun subscribeToData(): Flow<HistoryPreferenceModel>
    override suspend fun updateData(value: HistoryPreferenceModel?)
    override suspend fun getData(): HistoryPreferenceModel?
}