package dev.ya2048cc.domain.usecase.source.usecase.game

interface IsGameWonUseCase {
    suspend operator fun invoke():Boolean
}