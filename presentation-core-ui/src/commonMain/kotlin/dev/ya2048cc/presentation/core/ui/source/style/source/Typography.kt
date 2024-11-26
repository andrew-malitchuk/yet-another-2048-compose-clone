package dev.ya2048cc.presentation.core.ui.source.style.source

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dev.ya2048cc.presentation.core.ui.Res
import dev.ya2048cc.presentation.core.ui.pixelcode_black
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTypography
import org.jetbrains.compose.resources.Font

@Composable
fun PixelcodeFontFamily() = FontFamily(
    Font(
        Res.font.pixelcode_black,
        weight = FontWeight.Black,
        style = FontStyle.Normal,
    ),
)

@Composable
fun YacrukTypographyProvider(): YacrukTypography = YacrukTypography(
    display =
    TextStyle(
        fontSize = fontSize.display,
        lineHeight = lineHeight.display,
        fontWeight = FontWeight.Normal,
        fontFamily = PixelcodeFontFamily()
    ),
    headline =
    TextStyle(
        fontSize = fontSize.headline,
        lineHeight = lineHeight.headline,
        fontWeight = FontWeight.Normal,
        fontFamily = PixelcodeFontFamily()
    ),
    title =
    TextStyle(
        fontSize = fontSize.title,
        lineHeight = lineHeight.title,
        fontWeight = FontWeight.Medium,
        fontFamily = PixelcodeFontFamily()
    ),
    subHeading =
    TextStyle(
        fontSize = fontSize.subHeading,
        lineHeight = lineHeight.subHeading,
        fontWeight = FontWeight.Normal,
        fontFamily = PixelcodeFontFamily()
    ),
    body =
    TextStyle(
        fontSize = fontSize.body,
        lineHeight = lineHeight.body,
        fontWeight = FontWeight.Normal,
        fontFamily =
        PixelcodeFontFamily()
    ),
    caption =
    TextStyle(
        fontSize = fontSize.caption,
        lineHeight = lineHeight.caption,
        fontWeight = FontWeight.Normal,
        fontFamily = PixelcodeFontFamily()
    ),
    button =
    TextStyle(
        fontSize = fontSize.button,
        lineHeight = lineHeight.button,
        fontFamily = PixelcodeFontFamily()
    ),
)

