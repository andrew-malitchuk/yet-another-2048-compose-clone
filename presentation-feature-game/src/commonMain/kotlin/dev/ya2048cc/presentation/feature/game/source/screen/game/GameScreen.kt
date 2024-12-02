package dev.ya2048cc.presentation.feature.game.source.screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.ya2048cc.presentation.core.ui.Res
import dev.ya2048cc.presentation.core.ui.core.ext.noRippleClickable
import dev.ya2048cc.presentation.core.ui.ic_arrow_circle_down
import dev.ya2048cc.presentation.core.ui.ic_arrow_circle_left
import dev.ya2048cc.presentation.core.ui.ic_arrow_circle_right
import dev.ya2048cc.presentation.core.ui.ic_arrow_circle_up
import dev.ya2048cc.presentation.core.ui.ic_info_circle_24
import dev.ya2048cc.presentation.core.ui.source.component.widget.miscellaneous.Board
import dev.ya2048cc.presentation.core.ui.source.component.widget.button.ordinary.YacrukButton
import dev.ya2048cc.presentation.core.ui.source.component.widget.footer.Footer
import dev.ya2048cc.presentation.core.ui.source.component.widget.header.Header
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import dev.ya2048cc.domain.usecase.core.model.ScoreDomainModel
import dev.ya2048cc.domain.usecase.core.model.SwipeDomainModel
import dev.ya2048cc.domain.usecase.core.model.game.GameDomainModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun GameScreen(
    score: ScoreDomainModel?,
    game: GameDomainModel?,
    modifier: Modifier = Modifier,
    isHjklSelect: Boolean = false,
    onAction: ((GameAction) -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .background(YacrukTheme.colors.background)
            .statusBarsPadding()
            .padding(YacrukTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
        ) {

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Icon(
                modifier = Modifier
                    .size(42.dp)
                    .noRippleClickable {
                        onAction?.invoke(GameAction.GoToAbout)
                    }
                    .padding(8.dp),
                painter = painterResource(Res.drawable.ic_info_circle_24),
                // TODO
                contentDescription = ""
            )
        }
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )


        Header(
            score = score?.score ?: 0,
            bestScore = score?.highScore ?: 0,
            onNewAction = {
                onAction?.invoke(GameAction.NewGameAction)
            },
            onRedoAction = {
                onAction?.invoke(GameAction.RedoGameAction)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Board(
            grid = game?.grid?.current,
            onSwipe = { s, g ->
                onAction?.invoke(GameAction.OnSwipe(s, g))
            },
            onNewGame = {
                onAction?.invoke(GameAction.NewGameAction)
            }
        )

        if (isHjklSelect) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center
            ) {
                YacrukButton(
                    modifier = Modifier
                        .weight(1f),
                    borderWidth = 4.dp,
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(
                                Res.drawable.ic_arrow_circle_left,
                            ),
                            contentDescription = ""
                        )
                    },
                    text = "H",
                    onClick = {
                        onAction?.invoke(
                            GameAction.OnSwipe(
                                SwipeDomainModel.LEFT,
                                game?.grid?.current?.toMutableList() ?: emptyList()
                            )
                        )
                    }
                )
                YacrukButton(
                    modifier = Modifier
                        .weight(1f),
                    borderWidth = 4.dp,
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(
                                Res.drawable.ic_arrow_circle_down,
                            ),
                            contentDescription = ""
                        )
                    },
                    text = "J",
                    onClick = {
                        onAction?.invoke(
                            GameAction.OnSwipe(
                                SwipeDomainModel.DOWN,
                                game?.grid?.current?.toMutableList() ?: emptyList()
                            )
                        )
                    }
                )
                YacrukButton(
                    modifier = Modifier
                        .weight(1f),
                    borderWidth = 4.dp,
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(
                                Res.drawable.ic_arrow_circle_up,
                            ),
                            contentDescription = ""
                        )
                    },
                    text = "K",
                    onClick = {
                        onAction?.invoke(
                            GameAction.OnSwipe(
                                SwipeDomainModel.UP,
                                game?.grid?.current?.toMutableList() ?: emptyList()
                            )
                        )
                    }
                )
                YacrukButton(
                    modifier = Modifier
                        .weight(1f),
                    borderWidth = 4.dp,
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(
                                Res.drawable.ic_arrow_circle_right,
                            ),
                            contentDescription = ""
                        )
                    },
                    text = "L",
                    onClick = {
                        onAction?.invoke(
                            GameAction.OnSwipe(
                                SwipeDomainModel.RIGHT,
                                game?.grid?.current?.toMutableList() ?: emptyList()
                            )
                        )
                    }
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Footer(
            moves = score?.moves ?: 0,
            isHjklSelect = isHjklSelect,
            onSelect = {
                onAction?.invoke(GameAction.OnHjklSelect(it))
            }
        )
    }
}
