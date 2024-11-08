package dev.ya2048cc.app

import androidx.compose.ui.window.ComposeUIViewController
import dev.ya2048cc.app.di.initKoin
import dev.ya2048cc.presentation.feature.host.source.source.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}