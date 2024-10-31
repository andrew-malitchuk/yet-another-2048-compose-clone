package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game

import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.source.usecase.game.GetGameUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetGameUseCaseImpl(
    private val gameRepository: GameRepository
) : GetGameUseCase {
    override fun invoke(): Flow<GameDomainModel> {
        return gameRepository.subscribeToData().map { it.toDomain() }
    }
}