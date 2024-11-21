package dev.ya2048cc.presentation.core.ui.source.component.widget.footer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ya2048cc.presentation.core.ui.source.component.widget.switch.YacrukSwitchButton
import dev.ya2048cc.presentation.core.ui.source.component.widget.text.YacrukText
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme


@Composable
fun Footer(
    modifier: Modifier = Modifier,
    moves: Int,
    isHjklSelect:Boolean,
    onSelect: ((Boolean) -> Unit)? = null
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .alpha(0.65f)
    ) {
        YacrukText(
            text = "MV: $moves",
            textAlign = TextAlign.Center,
            fontSize = YacrukTheme.fontSize.headline,
            textStyle = YacrukTheme.typography.headline
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        YacrukText(
            text = "HJKL",
            textAlign = TextAlign.Center,
            fontSize = YacrukTheme.fontSize.title,
            textStyle = YacrukTheme.typography.title
        )
        Spacer(
            modifier = Modifier
                .width(YacrukTheme.spacing.small)
        )
        YacrukSwitchButton(
            initValue = isHjklSelect,
            borderWidth = 4.dp,
            height = 32.dp,
            width = 56.dp,
            thumbSize = 16.dp,
            onStateChange = onSelect
        )
    }
}