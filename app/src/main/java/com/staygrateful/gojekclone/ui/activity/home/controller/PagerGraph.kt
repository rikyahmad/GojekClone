package com.staygrateful.gojekclone.ui.activity.home.controller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.staygrateful.gojekclone.ui.activity.data.BottomNavItem
import com.staygrateful.gojekclone.ui.activity.home.screen.HomeScreen
import com.staygrateful.gojekclone.ui.activity.home.screen.OtherScreen

@Composable
fun PagerGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomNavItem.Home.screen_route
    ) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Promo.routeByArgs(),
            arguments = listOf(navArgument("value") {
                defaultValue = "Unknown"
                type = NavType.StringType
            })
        ) {
            OtherScreen(it.arguments?.getString("value") ?: "")
        }
        composable(BottomNavItem.Order.routeByArgs(),
            arguments = listOf(navArgument("value") {
                defaultValue = "Unknown"
            })
        ) {
            OtherScreen(it.arguments?.getString("value") ?: "")
        }
        composable(BottomNavItem.Chat.routeByArgs(),
            arguments = listOf(navArgument("value") {
                defaultValue = "Unknown"
            })
        ) {
            OtherScreen(it.arguments?.getString("value") ?: "")
        }
    }
}