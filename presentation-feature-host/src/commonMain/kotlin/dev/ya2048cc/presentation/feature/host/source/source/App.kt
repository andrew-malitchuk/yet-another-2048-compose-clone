package dev.ya2048cc.presentation.feature.host.source.source

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.ya2048cc.presentation.core.navigation.source.direction.NavigationDirection
import dev.ya2048cc.presentation.core.ui.source.style.source.YacrukTheme
import dev.ya2048cc.presentation.feature.host.source.navigation.HostNavigationGraph

@Composable
fun App(){
    val navHostController = rememberNavController()
    YacrukTheme {
        HostNavigationGraph(
            navHostController = navHostController,
            startDestination = NavigationDirection.Game
        )
    }
}