package dev.ya2048cc.domain.usecase.source.usecase.state

interface SavePreviousStateUseCase {
    suspend operator fun invoke()
}