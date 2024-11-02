package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.move

import dev.ya2048cc.data.repository.source.repository.ScoreRepository
import dev.ya2048cc.domain.usecase.source.usecase.move.OnMoveUseCase

class OnMoveUseCaseImpl(
    private val scoreRepository: ScoreRepository,
) : OnMoveUseCase {
    override suspend fun invoke() {
        with(scoreRepository) {
            val current = getData()
            current?.moves = (current?.moves ?: 0) + 1
            updateData(current)
        }
    }

}