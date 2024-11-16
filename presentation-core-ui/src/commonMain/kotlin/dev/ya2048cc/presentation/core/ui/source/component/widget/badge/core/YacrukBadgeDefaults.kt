package dev.ya2048cc.presentation.core.ui.source.component.widget.badge.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.ya2048cc.presentation.core.ui.source.style.source.color.bittersweet
import dev.ya2048cc.presentation.core.ui.source.style.source.color.renkon_beige

object YacrukBadgeDefaults {
    @Composable
    fun colors(
        badgeColor: Color = bittersweet,
        textColor: Color = renkon_beige,
    ) = YacrukBadgeColors(
        badgeColor = badgeColor,
        textColor = textColor,
    )
}
