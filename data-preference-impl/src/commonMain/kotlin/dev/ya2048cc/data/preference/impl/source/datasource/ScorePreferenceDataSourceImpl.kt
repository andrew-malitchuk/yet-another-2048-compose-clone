package dev.ya2048cc.data.preference.impl.source.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dev.ya2048cc.data.preference.core.model.ScorePreferenceModel
import dev.ya2048cc.data.preference.source.datasource.ScorePreferenceDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ScorePreferenceDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : ScorePreferenceDataSource {

    override fun subscribeToData(): Flow<ScorePreferenceModel> {
        return dataStore.data.map { preferences ->
            (preferences[stringPreferencesKey(KEY)])?.let {
                Json.decodeFromString<ScorePreferenceModel>(it)
            } ?: ScorePreferenceModel(0, 0, 0, 0)
        }
    }

    override suspend fun updateData(value: ScorePreferenceModel?) {
        value?.let {
            dataStore.edit { preferences ->
                preferences.set(
                    key = stringPreferencesKey(KEY),
                    value = Json.encodeToString(it)
                )
            }
        }
    }

    override suspend fun getData(): ScorePreferenceModel? {
        return dataStore.data
            .map { preferences ->
                preferences[stringPreferencesKey(KEY)]
            }.firstOrNull()?.let {
                Json.decodeFromString<ScorePreferenceModel>(it)
            }
    }

    companion object {
        const val KEY = "score"
    }
}