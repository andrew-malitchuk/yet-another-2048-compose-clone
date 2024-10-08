package dev.ya2048cc.data.repository.source.repository

import dev.ya2048cc.data.repository.core.model.HistoryRepositoryModel

interface HistoryRepository {
    suspend fun updateData(value: HistoryRepositoryModel?)
    suspend fun getData(): HistoryRepositoryModel?
}