package dev.ya2048cc.presentation.core.ui.source.style.source

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukColors
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukFontSize
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukSpacing
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukTypography
import dev.ya2048cc.presentation.core.ui.source.style.source.color.baseLightColorPalette

@Composable
@Suppress("FunctionNaming", "unused", "OptionalWhenBraces")
fun YacrukTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalYacrukColors provides baseLightColorPalette,
        LocalYacrukSpacing provides spacing,
        LocalYacrukTypography provides YacrukTypographyProvider(),
        LocalYacrukFontSize provides fontSize,
        content = content,
    )
}
