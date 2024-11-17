package dev.ya2048cc.presentation.core.ui.source.component.widget.border

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ya2048cc.presentation.core.ui.core.ext.yacrukBorder
import dev.ya2048cc.presentation.core.ui.source.component.widget.border.core.YacrukBorderColors
import dev.ya2048cc.presentation.core.ui.source.component.widget.border.core.YacrukBorderDefaults

/**
 * A composable function that displays a bordered container with customizable text, style, colors,
 * and inner content.
 *
 * @param modifier [Optional] Modifier to apply to the container. Defaults to an empty Modifier.
 * @param borderWidth The width of the border in dp.
 * @param text The text to display above the content.
 * @param padding The padding applied inside the border.
 * @param textStyle The text style for the displayed text.
 * @param colors The color scheme for the border and background. Defaults to the colors defined in `YacrukBorderDefaults.colors()`.
 * @param content The composable content to be displayed inside the border.
 */
@Composable
fun YacrukBorder(
    modifier: Modifier = Modifier,
    borderWidth: Dp,
    text: String,
    padding: Dp,
    textStyle: TextStyle,
    colors: YacrukBorderColors = YacrukBorderDefaults.colors(),
    content: @Composable () -> Unit,
) {


    val initialPadding = borderWidth * 2 + textStyle.fontSize.value.dp / 2

    Box(
        modifier =
        modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .yacrukBorder(
                textStyle = textStyle,
                borderWidth = borderWidth,
                backgroundColor = colors.backgroundColor,
                borderColor = colors.borderColor,
                text = text,
            )
            .padding(
                top = initialPadding + padding,
                bottom = padding,
                start = padding,
                end =
                padding,
            ),
    ) {
        content()
    }
}
