package dev.ya2048cc.domain.usecase.source.usecase.score

interface UpdateScoreUseCase {
    suspend operator fun invoke(score: Int)
}