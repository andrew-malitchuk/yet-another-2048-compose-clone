package dev.ya2048cc.data.preference.impl.source.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dev.ya2048cc.data.preference.core.model.GamePreferenceModel
import dev.ya2048cc.data.preference.core.model.GridPreferenceModel
import dev.ya2048cc.data.preference.source.datasource.GamePreferenceDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class GamePreferenceDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : GamePreferenceDataSource {
    override fun subscribeToData(): Flow<GamePreferenceModel> {
        return dataStore.data.map { preferences ->
            (preferences[stringPreferencesKey(KEY)])?.let {
                Json.decodeFromString<GamePreferenceModel>(it)
            } ?: GamePreferenceModel(GridPreferenceModel(0, mutableListOf()))
        }
    }

    override suspend fun updateData(value: GamePreferenceModel?) {
        value?.let {
            dataStore.edit { preferences ->
                preferences.set(
                    key = stringPreferencesKey(KEY),
                    value = Json.encodeToString(it)
                )
            }
        }
    }

    override suspend fun getData(): GamePreferenceModel? {
        return dataStore.data
            .map { preferences ->
                preferences[stringPreferencesKey(KEY)]
            }.firstOrNull()?.let {
                Json.decodeFromString<GamePreferenceModel>(it)
            }
    }

    companion object {
        const val KEY = "game"
    }
}