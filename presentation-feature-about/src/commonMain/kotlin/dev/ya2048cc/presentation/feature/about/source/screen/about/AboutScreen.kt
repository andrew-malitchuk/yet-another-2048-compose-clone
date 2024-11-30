package dev.ya2048cc.presentation.feature.about.source.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.ya2048cc.presentation.core.ui.Res
import dev.ya2048cc.presentation.core.ui.core.ext.noRippleClickable
import dev.ya2048cc.presentation.core.ui.ic_arrow_circle_left
import dev.ya2048cc.presentation.core.ui.source.component.widget.text.YacrukText
import dev.ya2048cc.presentation.core.ui.source.style.core.artifact.YacrukTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun AboutScreen(
    onAction: ((AboutAction)->Unit)?=null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(YacrukTheme.colors.background)
            .navigationBarsPadding()
            .statusBarsPadding()
            .padding(
                vertical = YacrukTheme.spacing.medium,
                horizontal = YacrukTheme.spacing.medium,
            ),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .noRippleClickable{
                    onAction?.invoke(AboutAction.OnNavBackClick)
                }
                .padding(8.dp),
            painter = painterResource(Res.drawable.ic_arrow_circle_left),
            // TODO
            contentDescription = ""
        )
        Spacer(
            modifier = Modifier
                .height(YacrukTheme.spacing.small)
        )
        YacrukText(
            modifier = Modifier
                .fillMaxWidth(),
            text = "YA2048CC",
            textAlign = TextAlign.Start,
            fontSize = YacrukTheme.fontSize.display,
            textStyle = YacrukTheme.typography.display,
        )
        Spacer(
            modifier = Modifier
                .height(YacrukTheme.spacing.small)
        )
        YacrukText(
            modifier = Modifier
                .fillMaxWidth(),
            text = "by Andrew Malitchuk",
            textAlign = TextAlign.Start,
            fontSize = YacrukTheme.fontSize.button,
            textStyle = YacrukTheme.typography.button,
        )
        Spacer(
            modifier = Modifier
                .height(YacrukTheme.spacing.large)
        )
        YacrukText(
            modifier = Modifier
                .fillMaxWidth(),
            isMarqueeEnabled = false,

            text = "YA2048CC is a Kotlin Multiplatform Compose implementation of the classic 2048 game, styled with a nostalgic retro LCD-inspired user interface for a unique gaming experience across platforms.",
            textAlign = TextAlign.Start,
            fontSize = YacrukTheme.fontSize.body,
            textStyle = YacrukTheme.typography.body,
        )
        Spacer(
            modifier = Modifier
                .height(YacrukTheme.spacing.large)
        )
        YacrukText(
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable {
                    onAction?.invoke(AboutAction.OnOpenLinkClick("https://github.com/andrew-malitchuk/yet-another-2048-compose-clone"))
                },
            isMarqueeEnabled = false,
            text = "/github",
            textAlign = TextAlign.Start,
            fontSize = YacrukTheme.fontSize.body,
            textStyle = YacrukTheme.typography.body,
        )
    }

}