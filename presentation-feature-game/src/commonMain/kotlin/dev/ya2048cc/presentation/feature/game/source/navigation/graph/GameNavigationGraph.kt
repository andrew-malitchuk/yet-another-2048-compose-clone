package dev.ya2048cc.presentation.feature.game.source.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import dev.ya2048cc.presentation.core.navigation.core.ext.safeNavigation
import dev.ya2048cc.presentation.core.navigation.source.direction.NavigationDirection
import dev.ya2048cc.presentation.feature.game.source.navigation.direction.GameDirection
import dev.ya2048cc.presentation.feature.game.source.screen.game.GameRoute

fun NavGraphBuilder.gameNavigationGraph(
    navController: NavHostController,
) {
    navigation<NavigationDirection.Game>(
        startDestination = GameDirection.Game,
    ) {
        composable<GameDirection.Game> {
            GameRoute {
                navController.safeNavigation(
                    route = it
                )
            }
        }
    }
}
