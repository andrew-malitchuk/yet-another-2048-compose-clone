package dev.ya2048cc.presentation.core.ui.source.component.widget.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import dev.ya2048cc.presentation.core.ui.Res
import dev.ya2048cc.presentation.core.ui.app_name
import dev.ya2048cc.presentation.core.ui.core.ext.marquee
import dev.ya2048cc.presentation.core.ui.core.ext.noRippleClickable
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import org.jetbrains.compose.resources.stringResource

/**
 * A composable function that displays formatted text with customization options.
 *
 * @param modifier [Optional] Modifier to apply to the text layout. Defaults to an empty Modifier.
 * @param text The text content to be displayed.
 * @param textStyle The text style defining font, size, and other visual properties.
 * @param color The text color. Defaults to [Color.Unspecified].
 * @param fontSize [Optional] The font size for the text. Defaults to the font size defined in the textStyle.
 * @param lineHeight [Optional] The line height for the text. Defaults to the line height defined in the textStyle.
 * @param textAlign [Optional] The horizontal alignment of the text. Defaults to null (left-aligned).
 * @param maxLines The maximum number of lines to display. Defaults to Int.MAX_VALUE (unlimited).
 * @param minLines The minimum number of lines to display. Defaults to 1.
 * @param isMarqueeEnabled Whether to enable marquee behavior (text scrolls if it overflows). Defaults to true.
 * @param onTextLayout [Optional] A callback lambda to receive information about the text layout after it's placed.
 * @param onClick [Optional] A callback lambda to be invoked when the text is clicked.
 */
@Composable
fun YacrukText(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle,
    color: Color = Color.Unspecified,
    fontSize: TextUnit? = null,
    lineHeight: TextUnit? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    isMarqueeEnabled: Boolean = true,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Text(
        text = text,
        modifier =
            modifier
                .noRippleClickable(onClick)
                .marquee(isMarqueeEnabled),
        color = color,
        style = textStyle,
        textAlign = textAlign,
        fontSize = fontSize ?: TextUnit.Unspecified,
        lineHeight = lineHeight ?: TextUnit.Unspecified,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
    )
}