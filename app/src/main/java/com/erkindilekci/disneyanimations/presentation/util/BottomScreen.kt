package com.erkindilekci.disneyanimations.presentation.util

sealed class BottomScreen(val route: String) {
    object Grid : BottomScreen(route = "grid")
    object Row : BottomScreen(route = "row")
}
