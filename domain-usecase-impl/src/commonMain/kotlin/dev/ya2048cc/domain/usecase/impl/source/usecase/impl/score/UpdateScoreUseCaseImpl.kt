package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.score

import dev.ya2048cc.data.repository.source.repository.ScoreRepository
import dev.ya2048cc.domain.usecase.source.usecase.score.UpdateScoreUseCase

class UpdateScoreUseCaseImpl(
    private val scoreRepository: ScoreRepository,
) : UpdateScoreUseCase {
    override suspend fun invoke(score: Int) {
        with(scoreRepository) {
            getData()?.let {
                if (it.score + score != it.score) {
                    it.score += score
                    if (it.highScore < it.score) {
                        it.highScore = it.score
                    }
                    scoreRepository.updateData(it)
                }
            }
        }
    }

}