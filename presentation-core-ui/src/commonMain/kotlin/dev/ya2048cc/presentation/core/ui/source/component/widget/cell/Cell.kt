package dev.ya2048cc.presentation.core.ui.source.component.widget.cell

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.ya2048cc.presentation.core.ui.core.ext.yacrukBorderAlt
import dev.ya2048cc.presentation.core.ui.core.ext.yacrukIconBorder
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import dev.ya2048cc.presentation.core.ui.source.style.source.color.ruined_smores

@Composable
fun Cell(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .yacrukBorderAlt(
                borderWidth = 4.dp,
                backgroundColor = Color(0xFF7B877A),
                borderColor = ruined_smores,
                borderColorAlt = Color(0xFF696e50)
            )
            .padding(YacrukTheme.spacing.extraSmall),

        ) {
        content()
    }
}