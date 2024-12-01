package dev.ya2048cc.presentation.feature.game.di

import dev.ya2048cc.presentation.feature.game.source.screen.game.GameViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val gameModule = module {
    viewModelOf(::GameViewModel)
}