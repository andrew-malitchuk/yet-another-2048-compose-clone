package dev.ya2048cc.data.preference.impl.source.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dev.ya2048cc.data.preference.core.model.HistoryPreferenceModel
import dev.ya2048cc.data.preference.source.datasource.HistoryPreferenceDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class HistoryPreferenceDataSourceImpl(
    private val dataStore: DataStore<Preferences>
) : HistoryPreferenceDataSource {

    override fun subscribeToData(): Flow<HistoryPreferenceModel> {
        return dataStore.data.map { preferences ->
            (preferences[stringPreferencesKey(KEY)])?.let {
                Json.decodeFromString<HistoryPreferenceModel>(it)
            } ?: HistoryPreferenceModel(emptyList())
        }
    }

    override suspend fun updateData(value: HistoryPreferenceModel?) {
        value?.let {
            dataStore.edit { preferences ->
                preferences.set(
                    key = stringPreferencesKey(KEY),
                    value = Json.encodeToString(it)
                )
            }
        }
    }

    override suspend fun getData(): HistoryPreferenceModel? {
        return dataStore.data
            .map { preferences ->
                preferences[stringPreferencesKey(KEY)]
            }.firstOrNull()?.let {
                Json.decodeFromString<HistoryPreferenceModel>(it)
            }
    }

    companion object {
        const val KEY = "history"
    }
}