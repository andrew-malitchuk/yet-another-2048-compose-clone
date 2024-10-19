package dev.ya2048cc.domain.usecase.source.usecase.game

import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel
import kotlinx.coroutines.flow.Flow

interface GetGameUseCase {
    operator fun invoke(): Flow<GameDomainModel>
}