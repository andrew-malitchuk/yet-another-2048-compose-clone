package dev.ya2048cc.domain.usecase.impl.source.usecase.impl.game

import dev.ya2048cc.data.repository.source.repository.GameRepository
import dev.ya2048cc.domain.usecase.core.model.game.GridDomainModel
import dev.ya2048cc.domain.usecase.core.model.SwipeDomainModel
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toDomain
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel.Companion.toRepository
import dev.ya2048cc.domain.usecase.core.model.game.GameStatusDomainModel
import dev.ya2048cc.domain.usecase.source.usecase.game.IsGameOverUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.IsGameWonUseCase
import dev.ya2048cc.domain.usecase.source.usecase.state.SavePreviousStateUseCase
import dev.ya2048cc.domain.usecase.source.usecase.game.SwipeScenario
import dev.ya2048cc.domain.usecase.source.usecase.move.OnMoveUseCase
import dev.ya2048cc.domain.usecase.source.usecase.score.UpdateScoreUseCase
import kotlin.math.abs

class SwipeScenarioImpl(
    private val gameRepository: GameRepository,
    private val isGameWonUseCase: IsGameWonUseCase,
    private val isGameOverUseCase: IsGameOverUseCase,
    private val updateScoreUseCase: UpdateScoreUseCase,
    private val onMoveUseCase: OnMoveUseCase,
    private val savePreviousStateUseCase: SavePreviousStateUseCase,
) : SwipeScenario {
    override suspend fun invoke(
        swipe: SwipeDomainModel,
        grid: List<IntArray>
    ): GameStatusDomainModel? {
        savePreviousStateUseCase()
        val currentGame = gameRepository.getData()?.toDomain()
        currentGame ?: return null
        var flipped = false
        var transposed = false

        when (swipe) {
            SwipeDomainModel.LEFT -> {
                currentGame.grid.apply {
                    transpose()
                    flip()
                }
                transposed = true
                flipped = true
            }

            SwipeDomainModel.RIGHT -> {
                currentGame.grid.apply {
                    transpose()
                }
                transposed = true
            }

            SwipeDomainModel.UP -> {
                currentGame.grid.apply {
                    flip()
                }
                flipped = true
            }

            else -> Unit
        }

        val past = currentGame.grid.copyOf()

        for (i in 0 until currentGame.grid.size) {
            currentGame.grid.current[i] = operate(currentGame.grid, currentGame.grid.current[i])
        }

        val changed = !currentGame.grid.isEqualTo(past)

        val diff = if (changed) findDifferences(
            past, currentGame.grid.current
        ) else 0

        if (changed) {
            onMoveUseCase()
        }

        if (flipped) currentGame.grid.flip()
        if (transposed) currentGame.grid.transpose()
        if (changed) currentGame.grid.addTile()

        updateScoreUseCase(diff)

        gameRepository.updateData(currentGame.toRepository())


        return when {
            isGameWonUseCase() -> GameStatusDomainModel.Won
            isGameOverUseCase() -> GameStatusDomainModel.Lose
            else -> GameStatusDomainModel.Move
        }
    }

    private fun operate(grid: GridDomainModel, row: IntArray): IntArray =
        combine(grid, slide(grid, row))

    private fun combine(grid: GridDomainModel, row: IntArray): IntArray {
        var arr = row
        for (i in grid.size - 1 downTo 1) {
            val a = arr[i]
            val b = arr[i - 1]
            if (a == b && a != 0) {
                arr[i] = a + b
                arr[i - 1] = 0
                arr = slide(grid, arr)
            }
        }
        return arr
    }

    private fun slide(grid: GridDomainModel, row: IntArray): IntArray {
        val arr = row.filter { it > 0 }.toMutableList()
        val missing = List(grid.size - arr.size) { 0 }
        arr.addAll(0, missing)
        return arr.toIntArray()
    }

    fun findDifferences(
        list1: List<IntArray>,
        list2: List<IntArray>
    ): Int {
        return abs(list1.sumOf { it.count { it != 0 } } -
                list2.sumOf { it.count { it != 0 } }
        )

    }

}