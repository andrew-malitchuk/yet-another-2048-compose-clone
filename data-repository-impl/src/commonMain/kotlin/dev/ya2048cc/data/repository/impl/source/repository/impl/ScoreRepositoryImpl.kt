package dev.ya2048cc.data.repository.impl.source.repository.impl

import dev.ya2048cc.data.preference.source.datasource.ScorePreferenceDataSource
import dev.ya2048cc.data.repository.source.repository.ScoreRepository
import dev.yapp.ya2048cc.data.repository.model.ScoreRepositoryModel
import dev.yapp.ya2048cc.data.repository.model.ScoreRepositoryModel.Companion.toPreference
import dev.yapp.ya2048cc.data.repository.model.ScoreRepositoryModel.Companion.toRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ScoreRepositoryImpl(
    private val scorePreferenceDataSource: ScorePreferenceDataSource
) : ScoreRepository {

    override fun subscribeToData(): Flow<ScoreRepositoryModel> {
        return scorePreferenceDataSource.subscribeToData().map {
            it.toRepository()
        }
    }

    override suspend fun updateData(value: ScoreRepositoryModel?) {
        scorePreferenceDataSource.updateData(value?.toPreference())
    }

    override suspend fun getData(): ScoreRepositoryModel {
        return scorePreferenceDataSource.getData()?.toRepository() ?: ScoreRepositoryModel(
            0,
            0,
            0,
            0
        )
    }
}