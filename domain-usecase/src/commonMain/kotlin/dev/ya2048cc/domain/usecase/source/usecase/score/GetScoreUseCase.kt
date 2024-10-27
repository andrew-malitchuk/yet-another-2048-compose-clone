package dev.ya2048cc.domain.usecase.source.usecase.score

import dev.ya2048cc.domain.usecase.core.model.ScoreDomainModel

interface GetScoreUseCase {
    operator fun invoke():kotlinx.coroutines.flow.Flow<ScoreDomainModel>
}