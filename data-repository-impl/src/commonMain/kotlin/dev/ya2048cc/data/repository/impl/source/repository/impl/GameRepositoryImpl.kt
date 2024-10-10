package dev.ya2048cc.data.repository.impl.source.repository.impl

import dev.ya2048cc.data.preference.source.datasource.GamePreferenceDataSource
import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.data.repository.core.model.GameRepositoryModel
import dev.ya2048cc.data.repository.core.model.GameRepositoryModel.Companion.toPreference
import dev.ya2048cc.data.repository.core.model.GameRepositoryModel.Companion.toRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepositoryImpl(
    private val gamePreferencesDataSource: GamePreferenceDataSource
) : GameRepository {

    override fun subscribeToData(): Flow<GameRepositoryModel> {
        return gamePreferencesDataSource.subscribeToData().map {
            it.toRepository()
        }
    }

    override suspend fun updateData(value: GameRepositoryModel?) {
        gamePreferencesDataSource.updateData(value?.toPreference())
    }

    override suspend fun getData(): GameRepositoryModel? {
        return gamePreferencesDataSource.getData()?.toRepository()
    }
}