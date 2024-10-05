package dev.ya2048cc.data.preference.impl.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import dev.ya2048cc.data.preference.impl.core.Ya2048ccPreference
import dev.ya2048cc.data.preference.impl.core.dataStoreFileName
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
actual val datastoreModule: Module = module {
    single<DataStore<Preferences>> {
        Ya2048ccPreference.getDataStore(
            producePath = {
                val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                    directory = NSDocumentDirectory,
                    inDomain = NSUserDomainMask,
                    appropriateForURL = null,
                    create = false,
                    error = null,
                )
                requireNotNull(documentDirectory).path + "/$dataStoreFileName"
            }
        )
    }
}