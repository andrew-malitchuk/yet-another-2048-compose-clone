package dev.ya2048cc.presentation.core.ui.source.component.widget.border.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.ya2048cc.presentation.core.ui.source.style.source.color.black_mesa
import dev.ya2048cc.presentation.core.ui.source.style.source.color.renkon_beige

object YacrukBorderDefaults {
    @Composable
    fun colors(
        borderColor: Color = black_mesa,
        backgroundColor: Color = renkon_beige,
    ) = YacrukBorderColors(
        borderColor = borderColor,
        backgroundColor = backgroundColor,
    )
}
