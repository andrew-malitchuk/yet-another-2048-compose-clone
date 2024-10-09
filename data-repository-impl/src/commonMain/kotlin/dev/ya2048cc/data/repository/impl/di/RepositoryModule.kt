package dev.ya2048cc.data.repository.impl.di

import dev.ya2048cc.data.repository.impl.source.repository.impl.GameRepositoryImpl
import dev.ya2048cc.data.repository.impl.source.repository.impl.HistoryRepositoryImpl
import dev.ya2048cc.data.repository.impl.source.repository.impl.ScoreRepositoryImpl
import dev.ya2048cc.data.repository.source.repository.HistoryRepository
import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.data.repository.source.repository.ScoreRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HistoryRepository> {
        HistoryRepositoryImpl(
            get()
        )
    }
    single<GameRepository> {
        GameRepositoryImpl(
            get()
        )
    }
    single<ScoreRepository> {
        ScoreRepositoryImpl(
            get()
        )
    }
}