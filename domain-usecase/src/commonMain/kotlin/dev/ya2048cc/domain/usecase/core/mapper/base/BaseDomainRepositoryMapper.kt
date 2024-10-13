package dev.ya2048cc.domain.usecase.core.mapper.base

import dev.ya2048cc.data.repository.core.model.base.BaseRepositoryModel
import dev.ya2048cc.domain.usecase.core.model.base.BaseDomainModel

interface BaseDomainRepositoryMapper<Domain : BaseDomainModel, Repository : BaseRepositoryModel> {
    fun Domain.toRepository(): Repository
    fun Repository.toDomain(): Domain
}