package dev.ya2048cc.data.preference.source.datasource.base

import kotlinx.coroutines.flow.Flow

interface BasePreferenceDataSource<T> {
    fun subscribeToData(): Flow<T?>
    suspend fun updateData(value: T?)
    suspend fun getData(): T?
}
