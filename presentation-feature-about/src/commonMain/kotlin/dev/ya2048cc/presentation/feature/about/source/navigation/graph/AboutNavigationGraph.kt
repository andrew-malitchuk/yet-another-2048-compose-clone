package dev.ya2048cc.presentation.feature.about.source.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.ya2048cc.presentation.core.navigation.source.direction.NavigationDirection
import dev.ya2048cc.presentation.feature.about.source.navigation.direction.AboutDirection
import dev.ya2048cc.presentation.feature.about.source.screen.about.AboutRoute

fun NavGraphBuilder.aboutNavigationGraph(
    navController: NavHostController,
) {
    navigation<NavigationDirection.About>(
        startDestination = AboutDirection.About,
    ) {
        composable<AboutDirection.About> {
            AboutRoute {
                navController.popBackStack()
            }
        }
    }
}
