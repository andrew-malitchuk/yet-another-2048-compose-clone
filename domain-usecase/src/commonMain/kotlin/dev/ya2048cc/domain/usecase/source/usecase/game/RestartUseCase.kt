package dev.ya2048cc.domain.usecase.source.usecase.game

interface RestartUseCase {
    suspend operator fun invoke()
}