package dev.ya2048cc.domain.usecase.source.usecase.game

interface NewGameUseCase {
    suspend operator fun invoke()
}