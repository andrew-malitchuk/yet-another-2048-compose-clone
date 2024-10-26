package dev.ya2048cc.domain.usecase.source.usecase.move

interface UndoMoveUseCase {
    suspend operator fun invoke()
}