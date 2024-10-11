package dev.ya2048cc.data.repository.impl.source.repository.impl

import dev.ya2048cc.data.preference.source.datasource.HistoryPreferenceDataSource
import dev.ya2048cc.data.repository.source.repository.HistoryRepository
import dev.ya2048cc.data.repository.core.model.HistoryRepositoryModel
import dev.ya2048cc.data.repository.core.model.HistoryRepositoryModel.Companion.toPreference
import dev.ya2048cc.data.repository.core.model.HistoryRepositoryModel.Companion.toRepository

class HistoryRepositoryImpl(
    private val historyPreferenceDataSource: HistoryPreferenceDataSource
) : HistoryRepository {

    override suspend fun updateData(value: HistoryRepositoryModel?) {
        historyPreferenceDataSource.updateData(value?.toPreference())
    }

    override suspend fun getData(): HistoryRepositoryModel? {
        return historyPreferenceDataSource.getData()?.toRepository()
    }
}