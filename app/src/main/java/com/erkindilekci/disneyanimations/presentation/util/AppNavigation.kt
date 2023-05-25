package com.erkindilekci.disneyanimations.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.erkindilekci.disneyanimations.presentation.detailscreen.AnimationDetailScreen
import com.erkindilekci.disneyanimations.presentation.listscreen.AnimationListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreen.ListScreen.route) {
        composable(AppScreen.ListScreen.route) {
            AnimationListScreen(navController = navController)
        }

        composable(
            route = "${AppScreen.DetailScreen.route}/{id}",
            arguments = listOf(
                navArgument(name = "id") { type = NavType.IntType }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: -1
            AnimationDetailScreen(id = id, navController = navController)
        }
    }
}
