package dev.ya2048cc.domain.usecase.core.model.game

import dev.ya2048cc.domain.usecase.core.model.base.BaseDomainModel

sealed class GameStatusDomainModel: BaseDomainModel {
    data object Won: GameStatusDomainModel()
    data object Lose: GameStatusDomainModel()
    data object Move: GameStatusDomainModel()
}