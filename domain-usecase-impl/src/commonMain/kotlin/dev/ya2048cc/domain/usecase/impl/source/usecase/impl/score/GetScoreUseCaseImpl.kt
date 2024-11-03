package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.score

import dev.ya2048cc.data.repository.source.repository.ScoreRepository
import dev.ya2048cc.domain.usecase.source.usecase.score.GetScoreUseCase
import dev.ya2048cc.domain.usecase.core.model.ScoreDomainModel
import dev.ya2048cc.domain.usecase.core.model.ScoreDomainModel.Companion.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetScoreUseCaseImpl(
    private val scoreRepository: ScoreRepository
) : GetScoreUseCase {
    override fun invoke(): Flow<ScoreDomainModel> {
       return scoreRepository.subscribeToData().map { it.toDomain() }
    }
}