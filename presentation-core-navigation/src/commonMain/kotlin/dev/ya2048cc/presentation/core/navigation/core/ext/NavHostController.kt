package dev.ya2048cc.presentation.core.navigation.core.ext

import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator.Extras

fun <T : Any> NavHostController.safeNavigation(
    route: T,
    navOptions: NavOptions? = null,
    navigatorExtras: Extras? = null,
    cleanBackStack: Boolean = false,
) {
    try {
        if (cleanBackStack) {
            this.popBackStack()
        }
        this.navigate(route, navOptions, navigatorExtras)
    } catch (ex: Exception) {
        // TODO: log
    }
}


