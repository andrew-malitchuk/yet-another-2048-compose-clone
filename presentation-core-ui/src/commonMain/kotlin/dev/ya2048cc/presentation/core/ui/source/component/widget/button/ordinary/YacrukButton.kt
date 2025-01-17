package dev.ya2048cc.presentation.core.ui.source.component.widget.button.ordinary
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.PressInteraction.Release
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.ya2048cc.presentation.core.ui.core.ext.yacrukBorderAlt
import dev.ya2048cc.presentation.core.ui.source.component.widget.button.ordinary.YacrukButtonClickState.Clicked.toggleClick
import dev.ya2048cc.presentation.core.ui.source.component.widget.text.YacrukText
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import dev.ya2048cc.presentation.core.ui.source.style.source.color.black_mesa
import dev.ya2048cc.presentation.core.ui.source.style.source.color.jambalaya
import dev.ya2048cc.presentation.core.ui.source.style.source.color.renkon_beige
import dev.ya2048cc.presentation.core.ui.source.style.source.color.rustling_leaves
import dev.ya2048cc.presentation.core.ui.source.style.source.color.stone_craft

/**
 * A composable function that displays a clickable button with customizable size, border, text,
 * optional icon, interaction states, and colors.
 *
 * @param modifier [Optional] Modifier to apply to the button. Defaults to an empty Modifier.
 * @param borderWidth The width of the border in dp.
 * @param text The text to be displayed on the button.
 * @param primaryState The initial state of the button (Enabled, Clicked, Disabled). Defaults to Enabled.
 * @param icon [Optional] A composable lambda representing the icon to be displayed on the button.
 * @param iconOffset The padding applied between the icon and the text content. Defaults to YacrukTheme.spacing.small.
 * @param isDisabled Whether the button is disabled and not clickable. Defaults to false.
 * @param colors The color scheme for the button's border, text, and background. Defaults to the colors defined in `YacrukButtonDefaults.colors()`.
 * @param interactionSource A source for handling user interactions with the button.
 * @param onClick The callback function to be invoked when the button is clicked. Can be null.
 */
@Composable
fun YacrukButton(
    modifier: Modifier = Modifier,
    borderWidth: Dp,
    text: String,
    primaryState: YacrukButtonClickState = YacrukButtonClickState.Enabled,
    icon: (@Composable () -> Unit)? = null,
    iconOffset: Dp = YacrukTheme.spacing.small,
    isDisabled: Boolean = false,
    colors: YacrukButtonColors = YacrukButtonDefaults.colors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: (() -> Unit)? = null,
) {


    val haptic = LocalHapticFeedback.current

    var clickState: YacrukButtonClickState by remember {
        mutableStateOf(primaryState)
    }
    var hoverStateState: YacrukButtonHoverState by remember {
        mutableStateOf(YacrukButtonHoverState.Default)
    }

    val offset by animateDpAsState(
        targetValue =
        when (clickState) {
            YacrukButtonClickState.Clicked -> (borderWidth * 2) + borderWidth
            YacrukButtonClickState.Enabled -> (borderWidth * 2)
            else -> (borderWidth * 2)
        },
        label = "offset",
    )

    val borderColorAltState by animateColorAsState(
        targetValue =
        when (hoverStateState) {
            YacrukButtonHoverState.Hovered -> colors.borderColorAlt
            YacrukButtonHoverState.Default -> Color.Transparent
            YacrukButtonHoverState.Disabled -> Color.Transparent
        },
        label = "borderColorAltState",
    )

    val backgroundColorState by animateColorAsState(
        targetValue =
        when (hoverStateState) {
            YacrukButtonHoverState.Hovered -> colors.hoverColor
            YacrukButtonHoverState.Disabled -> colors.disableColor
            else -> colors.backgroundColor
        },
        label = "backgroundColorAltState",
    )

    val sizeState by animateFloatAsState(
        targetValue =
        when (hoverStateState) {
            YacrukButtonHoverState.Hovered -> 0.9f
            else -> 1f
        },
        label = "borderColorAltState",
    )

    val interactions = remember { mutableStateListOf<Interaction>() }
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    hoverStateState = YacrukButtonHoverState.Hovered
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    interactions.add(interaction)
                }

                is Release -> {
                    hoverStateState = YacrukButtonHoverState.Default
                    clickState = clickState.toggleClick()
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    interactions.remove(interaction.press)
                }

                is PressInteraction.Cancel -> {
                    hoverStateState = YacrukButtonHoverState.Default
                    interactions.remove(interaction.press)
                }

                is DragInteraction.Start ->
                    interactions.add(interaction)

                is DragInteraction.Stop ->
                    interactions.remove(interaction.start)

                is DragInteraction.Cancel -> {
                    hoverStateState = YacrukButtonHoverState.Default
                    clickState = YacrukButtonClickState.Disabled
                    interactions.add(interaction.start)
                }
            }
        }
    }

    Box(
        modifier =
        modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = true,
                onClick = {
                    if (!isDisabled) {
                        onClick?.invoke()
                    }
                },
            )
            .yacrukBorderAlt(
                borderWidth = borderWidth,
                borderColor = colors.borderColor,
                backgroundColor = backgroundColorState,
                borderColorAlt = borderColorAltState,
            ),
    ) {
        Row(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(
                    start = offset,
                    bottom = borderWidth * 2,
                    top = borderWidth * 2,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let {
                Box(modifier = Modifier.scale(sizeState)) {
                    it()
                }
                Spacer(modifier = Modifier.width(iconOffset * sizeState))
            }
            Row(
                modifier =
                Modifier
                    .height(
                        YacrukTheme.typography.headline.lineHeight.value.dp,
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                YacrukText(
                    modifier =
                    Modifier
                        .height(
                            YacrukTheme.typography.headline.lineHeight.value.dp * sizeState,
                        ),
                    text = text,
                    textStyle = YacrukTheme.typography.headline,
                    fontSize =
                    TextUnit(
                        value = YacrukTheme.typography.headline.fontSize.value * sizeState,
                        TextUnitType.Sp,
                    ),
                )
            }
        }
    }
}

sealed class YacrukButtonClickState {
    data object Enabled : YacrukButtonClickState()

    data object Clicked : YacrukButtonClickState()

    data object Disabled : YacrukButtonClickState()

    fun YacrukButtonClickState.toggleClick(): YacrukButtonClickState {
        return when {
            this is Enabled -> Clicked
            else -> Enabled
        }
    }
}

sealed class YacrukButtonHoverState {
    data object Hovered : YacrukButtonHoverState()

    data object Disabled : YacrukButtonHoverState()

    data object Default : YacrukButtonHoverState()
}

class YacrukButtonColors internal constructor(
    val backgroundColor: Color,
    val borderColor: Color,
    val borderColorAlt: Color,
    val hoverColor: Color,
    val disableColor: Color,
)

object YacrukButtonDefaults {
    @Composable
    fun colors(
        backgroundColor: Color = renkon_beige,
        borderColor: Color = black_mesa,
        borderColorAlt: Color = rustling_leaves,
        hoverColor: Color = stone_craft,
        disableColor: Color = jambalaya,
    ) = YacrukButtonColors(
        backgroundColor = backgroundColor,
        borderColor = borderColor,
        borderColorAlt = borderColorAlt,
        hoverColor = hoverColor,
        disableColor = disableColor,
    )
}
