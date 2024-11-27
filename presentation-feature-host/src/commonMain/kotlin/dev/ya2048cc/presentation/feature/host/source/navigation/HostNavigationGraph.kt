package dev.ya2048cc.presentation.feature.host.source.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.ya2048cc.presentation.feature.about.source.navigation.graph.aboutNavigationGraph
import dev.ya2048cc.presentation.feature.game.source.navigation.graph.gameNavigationGraph

@Composable
fun HostNavigationGraph(
    navHostController: NavHostController,
    startDestination: Any,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        gameNavigationGraph(navHostController)
        aboutNavigationGraph(navHostController)
    }
}
