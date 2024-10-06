package dev.ya2048cc.data.preference.impl.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.ya2048cc.data.preference.impl.core.Ya2048ccPreference
import dev.ya2048cc.data.preference.impl.core.dataStoreFileName
import org.koin.core.module.Module
import org.koin.dsl.module

actual val datastoreModule: Module = module {
    single<DataStore<Preferences>> {
        val context: Context = get()
        Ya2048ccPreference.getDataStore(
            producePath = {
                context.filesDir
                    .resolve(dataStoreFileName)
                    .absolutePath
            }
        )
    }
}