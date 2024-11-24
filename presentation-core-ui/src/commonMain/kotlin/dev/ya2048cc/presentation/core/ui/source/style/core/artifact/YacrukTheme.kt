package dev.ya2048cc.presentation.core.ui.source.style.core.artifact

import androidx.compose.runtime.Composable
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukColors
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukFontSize
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukLineHeight
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukSpacing
import dev.ya2048cc.presentation.core.ui.source.style.core.provider.LocalYacrukTypography

@Suppress("unused")
object YacrukTheme {
    val colors: YacrukColor
        @Composable
        get() = LocalYacrukColors.current
    val fontSize: YacrukFontSize
        @Composable
        get() = LocalYacrukFontSize.current
    val lineHeight: YacrukLineHeight
        @Composable
        get() = LocalYacrukLineHeight.current
    val spacing: YacrukSpacing
        @Composable
        get() = LocalYacrukSpacing.current
    val typography: YacrukTypography
        @Composable
        get() = LocalYacrukTypography.current
}
