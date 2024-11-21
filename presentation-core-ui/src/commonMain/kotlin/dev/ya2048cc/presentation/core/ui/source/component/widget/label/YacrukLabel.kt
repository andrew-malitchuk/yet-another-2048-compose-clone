package dev.ya2048cc.presentation.core.ui.source.component.widget.label

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import dev.ya2048cc.presentation.core.ui.source.component.widget.text.YacrukText
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme

/**
 * A composable function that displays a labeled section with a title, optional padding,
 * and a content slot for additional composables.
 *
 * @param modifier [Optional] Modifier to apply to the label composable. Defaults to an empty Modifier.
 * @param title The text displayed as the label title.
 * @param padding [Optional] The spacing between the title and the content in dp. Defaults to YacrukTheme.spacing.small.
 * @param textStyle The text style to apply to the title.
 * @param color [Optional] The text color for the title. Defaults to Color.Unspecified.
 * @param content A lambda composable that defines the content to be placed below the title.
 */
@Composable
fun YacrukLabel(
    modifier: Modifier = Modifier,
    title: String,
    padding: Dp = YacrukTheme.spacing.small,
    textStyle: TextStyle,
    color: Color = Color.Unspecified,
    content: @Composable () -> Unit,
) {
    Column(
        modifier =
            modifier
                .wrapContentHeight(),
    ) {
        YacrukText(text = title, textStyle = textStyle, color = color)
        Spacer(modifier = Modifier.height(padding))
        content()
    }
}