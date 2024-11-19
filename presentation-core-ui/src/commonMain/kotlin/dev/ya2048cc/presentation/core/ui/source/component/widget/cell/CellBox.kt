package dev.ya2048cc.presentation.core.ui.source.component.widget.cell

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ya2048cc.presentation.core.ui.source.component.widget.text.YacrukText
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme

@Composable
fun CellBox(number: Int, size: Dp, dx: Int = 0, dy: Int = 0) {

    val x by animateDpAsState(targetValue = Dp(dx * size.value))
    val y by animateDpAsState(targetValue = Dp(dy * size.value))

    Cell(
        modifier = Modifier
            .size(size)
            .padding(YacrukTheme.spacing.small)
            .absoluteOffset(x, y)
    ) {
        if (number != 0) {
            YacrukText(
                text = "$number",
                textAlign = TextAlign.Center,
                fontSize = YacrukTheme.fontSize.headline,
                textStyle = YacrukTheme.typography.headline
            )
        }
    }
}