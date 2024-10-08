package dev.ya2048cc.data.repository.source.repository

import dev.yapp.ya2048cc.data.repository.model.ScoreRepositoryModel
import kotlinx.coroutines.flow.Flow

interface ScoreRepository {
    fun subscribeToData(): Flow<ScoreRepositoryModel>
    suspend fun updateData(value: ScoreRepositoryModel?)
    suspend fun getData(): ScoreRepositoryModel?
}