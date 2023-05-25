package com.erkindilekci.disneyanimations.presentation.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.erkindilekci.disneyanimations.domain.model.Animation
import com.erkindilekci.disneyanimations.presentation.listscreen.components.AnimationListCardGrid
import com.erkindilekci.disneyanimations.presentation.listscreen.components.AnimationListCardRow
import com.erkindilekci.disneyanimations.presentation.ui.theme.myBackgroundColor

@Composable
fun AnimationListScreenNavigation(
    navController: NavHostController,
    animations: List<Animation>,
    padding: PaddingValues,
    onItemClicked: (Int) -> Unit
) {
    NavHost(navController = navController, startDestination = BottomScreen.Grid.route) {
        composable(BottomScreen.Grid.route) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(180.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.myBackgroundColor)
                    .padding(padding)
                    .padding(end = 16.dp)
            ) {
                items(animations) { animation ->
                    AnimationListCardGrid(animation = animation, onItemClicked = onItemClicked)
                }
            }
        }

        composable(BottomScreen.Row.route) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.myBackgroundColor)
                    .padding(padding)
            ) {
                items(animations) { animation ->
                    AnimationListCardRow(animation = animation, onItemClicked = onItemClicked)
                }
            }
        }
    }
}
