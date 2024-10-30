package dev.ya2048cc.domain.usecase.impl.di

import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.score.GetScoreUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.move.UndoMoveUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game.GetGameUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game.IsGameOverUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game.IsGameWonUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game.NewGameUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game.RestartUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.state.SavePreviousStateUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game.SwipeScenarioImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.move.OnMoveUseCaseImpl
import dev.ya2048cc.domain.usecase.impl.source.usecase.impl.score.UpdateScoreUseCaseImpl
import dev.ya2048cc.domain.usecase.source.usecase.game.GetGameUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.IsGameOverUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.IsGameWonUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.NewGameUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.RestartUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.SwipeScenario
import dev.ya2048cc.domain.usecase.source.usecase.move.OnMoveUseCase
import dev.ya2048cc.domain.usecase.source.usecase.move.UndoMoveUseCase
import dev.ya2048cc.domain.usecase.source.usecase.score.GetScoreUseCase
import dev.ya2048cc.domain.usecase.source.usecase.score.UpdateScoreUseCase
import dev.ya2048cc.domain.usecase.source.usecase.state.SavePreviousStateUseCase
import org.koin.dsl.module

val domainModule = module {
    single<GetGameUseCase> {
        GetGameUseCaseImpl(
            get(),
        )
    }
    single<IsGameOverUseCase> {
        IsGameOverUseCaseImpl(
            get(),
        )
    }
    single<IsGameWonUseCase> {
        IsGameWonUseCaseImpl(
            get(),
        )
    }
    single<NewGameUseCase> {
        NewGameUseCaseImpl(
            get(),
            get(),
            get(),
        )
    }
    single<RestartUseCase> {
        RestartUseCaseImpl(
            get(),
        )
    }
    single<SwipeScenario> {
        SwipeScenarioImpl(
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
        )
    }
    single<GetScoreUseCase> {
        GetScoreUseCaseImpl(
            get()
        )
    }
    single<UndoMoveUseCase> {
        UndoMoveUseCaseImpl(
            get(),
            get(),
            get(),
        )
    }
    single<UpdateScoreUseCase> {
        UpdateScoreUseCaseImpl(
            get(),
        )
    }
    single<OnMoveUseCase> {
        OnMoveUseCaseImpl(
            get(),
        )
    }
    single<SavePreviousStateUseCase> {
        SavePreviousStateUseCaseImpl(
            get(),
            get(),
        )
    }
}