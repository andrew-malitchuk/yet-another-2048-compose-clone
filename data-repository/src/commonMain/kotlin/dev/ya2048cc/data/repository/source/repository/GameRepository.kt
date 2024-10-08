package dev.ya2048cc.data.repository.source.repository

import dev.ya2048cc.data.repository.core.model.GameRepositoryModel
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun subscribeToData(): Flow<GameRepositoryModel>
    suspend fun updateData(value: GameRepositoryModel?)
    suspend fun getData(): GameRepositoryModel?
}