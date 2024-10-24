package dev.ya2048cc.domain.usecase.source.usecase.game

import dev.ya2048cc.domain.usecase.core.model.SwipeDomainModel
import dev.ya2048cc.domain.usecase.core.model.game.GameStatusDomainModel

interface SwipeScenario {
    suspend operator fun invoke(swipe: SwipeDomainModel, grid:List<IntArray>): GameStatusDomainModel?
}