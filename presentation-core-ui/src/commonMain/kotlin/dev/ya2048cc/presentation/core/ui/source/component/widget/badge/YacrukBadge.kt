package dev.ya2048cc.presentation.core.ui.source.component.widget.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ya2048cc.presentation.core.ui.source.component.widget.badge.core.YacrukBadgeColors
import dev.ya2048cc.presentation.core.ui.source.component.widget.badge.core.YacrukBadgeDefaults
import dev.ya2048cc.presentation.core.ui.source.component.widget.text.YacrukText
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import dev.ya2048cc.presentation.core.ui.source.style.source.YacrukTheme

/**
 * A composable function that displays a badge with customizable text, style, shape, and colors.
 *
 * @param modifier [Optional] Modifier to apply to the badge. Defaults to an empty Modifier.
 * @param text The text to display inside the badge.
 * @param textStyle The text style for the badge text.
 * @param shape The shape of the badge.
 * @param padding [Optional] Padding to apply inside the badge. Defaults to 2dp.
 * @param colors The color scheme for the badge. Defaults to the colors defined in `YacrukBadgeDefaults.colors()`.
 */
@Composable
fun YacrukBadge(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    shape: Shape,
    padding: Dp = 2.dp,
    colors: YacrukBadgeColors = YacrukBadgeDefaults.colors(),
) {
    Box(
        modifier =
            modifier
                .clip(shape)
                .background(colors.badgeColor)
                .wrapContentSize()
                .padding(padding),
        contentAlignment = Alignment.Center,
    ) {
        YacrukText(
            modifier =
                Modifier
                    .height(
                        textStyle.lineHeight.value.dp,
                    ),
            text = text,
            textStyle = textStyle,
            color = colors.textColor,
        )
    }
}
