package dev.ya2048cc.presentation.feature.about.source.screen.about

sealed class AboutAction {
    data class OnOpenLinkClick(val url: String) : AboutAction()
    data object OnNavBackClick : AboutAction()
}