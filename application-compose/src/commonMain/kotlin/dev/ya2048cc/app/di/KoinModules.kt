package dev.ya2048cc.app.di

import dev.ya2048cc.data.preference.impl.di.datastoreModule
import dev.ya2048cc.data.repository.impl.di.repositoryModule
import dev.ya2048cc.domain.usecase.impl.di.domainModule
import dev.ya2048cc.presentation.feature.game.di.gameModule
import dev.ya2048cc.data.preference.impl.di.preferenceModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            preferenceModule,
            domainModule,
            repositoryModule,
            gameModule,
            datastoreModule
        )
    }