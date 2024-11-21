package dev.ya2048cc.presentation.core.ui.source.component.widget.header

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ya2048cc.presentation.core.ui.Res
import dev.ya2048cc.presentation.core.ui.ic_refresh_24
import dev.ya2048cc.presentation.core.ui.ic_shuffle_24
import dev.ya2048cc.presentation.core.ui.source.component.widget.border.YacrukBorder
import dev.ya2048cc.presentation.core.ui.source.component.widget.button.content.YacrukContentButton
import dev.ya2048cc.presentation.core.ui.source.component.widget.button.content.YacrukContentButtonClickState
import dev.ya2048cc.presentation.core.ui.source.component.widget.button.ordinary.YacrukButton
import dev.ya2048cc.presentation.core.ui.source.component.widget.cell.Cell
import dev.ya2048cc.presentation.core.ui.source.component.widget.text.YacrukText
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun Header(
    score: Int,
    bestScore: Int,
    modifier: Modifier = Modifier,
    onNewAction: (() -> Unit)? = null,
    onRedoAction: (() -> Unit)? = null,
) {
    YacrukBorder(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize(),
        borderWidth = 4.dp,
        text = "2048",
        padding = YacrukTheme.spacing.small,
        textStyle = YacrukTheme.typography.body,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(),
            verticalArrangement = Arrangement.spacedBy(YacrukTheme.spacing.small)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(YacrukTheme.spacing.small),
            ) {
                Cell(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(YacrukTheme.spacing.small),
                    ) {
                        YacrukText(
                            text = "Score",
                            textAlign = TextAlign.Center,
                            fontSize = YacrukTheme.fontSize.body,
                            textStyle = YacrukTheme.typography.body,
                            color = Color(0xFF696e50)
                        )
                        YacrukText(
                            text = "$score",
                            textAlign = TextAlign.Center,
                            fontSize = YacrukTheme.fontSize.body,
                            textStyle = YacrukTheme.typography.body,
                        )
                    }
                }
                Cell(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(YacrukTheme.spacing.small),
                        horizontalAlignment = Alignment.Start
                    ) {
                        YacrukText(
                            text = "Best",
                            textAlign = TextAlign.Center,
                            fontSize = YacrukTheme.fontSize.body,
                            textStyle = YacrukTheme.typography.body,
                            color = Color(0xFF696e50)
                        )
                        YacrukText(
                            text = "$bestScore",
                            textAlign = TextAlign.Center,
                            fontSize = YacrukTheme.fontSize.body,
                            textStyle = YacrukTheme.typography.body,
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                horizontalArrangement = Arrangement.spacedBy(YacrukTheme.spacing.small),

                ) {
                YacrukButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.7f),
                    borderWidth = 4.dp,
                    text = "New",
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(Res.drawable.ic_shuffle_24),
                            //TODO
                            contentDescription = ""
                        )
                    },
                    onClick = {
                        onNewAction?.invoke()
                    }
                )
                YacrukButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.7f),
                    borderWidth = 4.dp,
                    icon = {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = painterResource(Res.drawable.ic_refresh_24),
                            //TODO
                            contentDescription = ""
                        )
                    },
                    text = "Redo",
                    onClick = {
                        onRedoAction?.invoke()
                    }
                )
            }
        }
    }

}