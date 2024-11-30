package dev.ya2048cc.presentation.feature.about.source.screen.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun AboutRoute(
    onTransition: () -> Unit
) {
    val uriHandler = LocalUriHandler.current
    AboutScreen { action ->
        when (action) {
            AboutAction.OnNavBackClick -> onTransition()
            is AboutAction.OnOpenLinkClick -> uriHandler.openUri(action.url)
        }
    }
}