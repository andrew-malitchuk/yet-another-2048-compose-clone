package dev.ya2048cc.data.preference.impl.di

import dev.ya2048cc.data.preference.impl.source.datasource.GamePreferenceDataSourceImpl
import dev.ya2048cc.data.preference.impl.source.datasource.HistoryPreferenceDataSourceImpl
import dev.ya2048cc.data.preference.impl.source.datasource.ScorePreferenceDataSourceImpl
import dev.ya2048cc.data.preference.source.datasource.GamePreferenceDataSource
import dev.ya2048cc.data.preference.source.datasource.HistoryPreferenceDataSource
import dev.ya2048cc.data.preference.source.datasource.ScorePreferenceDataSource
import org.koin.dsl.module

val preferenceModule = module {
    single<HistoryPreferenceDataSource> {
        HistoryPreferenceDataSourceImpl(
            get(),
        )
    }

    single<GamePreferenceDataSource> {
        GamePreferenceDataSourceImpl(
            get(),
        )
    }

    single<ScorePreferenceDataSource> {
        ScorePreferenceDataSourceImpl(
            get(),
        )
    }

}