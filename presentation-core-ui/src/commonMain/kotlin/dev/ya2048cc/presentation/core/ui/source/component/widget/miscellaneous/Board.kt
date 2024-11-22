package dev.ya2048cc.presentation.core.ui.source.component.widget.miscellaneous

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import dev.ya2048cc.presentation.core.ui.Res
import dev.ya2048cc.presentation.core.ui.ic_star_24
import dev.ya2048cc.presentation.core.ui.source.component.widget.border.YacrukBorder
import dev.ya2048cc.presentation.core.ui.source.component.widget.button.ordinary.YacrukButton
import dev.ya2048cc.presentation.core.ui.source.component.widget.cell.CellBox
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import dev.ya2048cc.domain.usecase.core.model.SwipeDomainModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun Board(
    grid: List<IntArray>?,
    onSwipe: ((SwipeDomainModel, List<IntArray>) -> Unit)? = null,
    onNewGame: (() -> Unit)? = null
) {
    YacrukBorder(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        borderWidth = 4.dp,
        text = "Game board",
        padding = YacrukTheme.spacing.small,
        textStyle = YacrukTheme.typography.body,
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(YacrukTheme.spacing.medium)
                .pointerInput(Unit) {
                    var direction: SwipeDomainModel? = null
                    detectHorizontalDragGestures(
                        onDragEnd = {
                            direction?.let {
                                onSwipe?.invoke(
                                    it,
                                    grid?.toMutableList()?: emptyList()
                                )
                            }
                        },
                    ) { change, x ->
                        change.consume()
                        when {
                            x > 50 -> direction = SwipeDomainModel.RIGHT
                            x < -50 -> direction = SwipeDomainModel.LEFT
                        }
                    }
                }
                .pointerInput(Unit) {
                    var direction: SwipeDomainModel? = null
                    detectVerticalDragGestures(
                        onDragEnd = {
                            direction?.let {
                                onSwipe?.invoke(
                                    it,
                                    grid?.toMutableList()?: emptyList()
                                )
                            }
                        },
                    ) { change, y ->
                        change.consume()
                        when {
                            y > 50 -> direction = SwipeDomainModel.DOWN
                            y < -50 -> direction = SwipeDomainModel.UP
                        }
                    }
                }
        ) {

            when (isEmpty(grid?: emptyList())) {
                true ->
                    YacrukButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        borderWidth = 4.dp,
                        text = "NEW GAME",
                        icon = {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                painter = painterResource(Res.drawable.ic_star_24),
                                //TODO
                                contentDescription = ""
                            )
                        },
                        onClick = {
                            onNewGame?.invoke()
                        }
                    )

                false -> {
                    grid?.let {
                        val tileSize = maxWidth / it.size

                        for (i in it.indices) {
                            for (j in it.indices) {
                                CellBox(number = it[i][j], size = tileSize, i, j)
                            }
                        }
                    }
                }
            }


        }
    }
}

fun isEmpty(grid: List<IntArray>): Boolean {
    return grid.sumOf { array ->
        array.sum()
    } == 0
}