package dev.ya2048cc.domain.usecase.source.usecase.game

interface IsGameOverUseCase {
    suspend operator fun invoke():Boolean
}