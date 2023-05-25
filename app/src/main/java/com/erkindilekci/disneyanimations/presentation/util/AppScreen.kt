package com.erkindilekci.disneyanimations.presentation.util

sealed class AppScreen(val route: String) {
    object ListScreen : AppScreen(route = "list_screen")
    object DetailScreen : AppScreen(route = "detail_screen")
}
