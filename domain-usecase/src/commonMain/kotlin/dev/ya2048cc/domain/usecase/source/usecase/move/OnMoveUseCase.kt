package dev.ya2048cc.domain.usecase.source.usecase.move

interface OnMoveUseCase {
    suspend operator fun invoke()
}