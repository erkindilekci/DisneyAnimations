package com.erkindilekci.disneyanimations.presentation.listscreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.erkindilekci.disneyanimations.R
import com.erkindilekci.disneyanimations.presentation.ui.theme.myCardColor
import com.erkindilekci.disneyanimations.presentation.util.BottomScreen

@Composable
fun AnimationListBottomBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.height(80.dp),
        containerColor = MaterialTheme.myCardColor,
        contentColor = MaterialTheme.colorScheme.onBackground,

        ) {
        NavigationBarItem(
            label = {
                Text(text = stringResource(id = R.string.grid))
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.grid),
                    contentDescription = stringResource(id = R.string.grid)
                )
            },
            selected = currentDestination?.hierarchy?.any { destination ->
                destination.route == BottomScreen.Grid.route
            } == true,
            onClick = {
                navController.navigate(BottomScreen.Grid.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )

        NavigationBarItem(
            label = {
                Text(text = stringResource(R.string.row))
            },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.row),
                    contentDescription = stringResource(id = R.string.row)
                )
            },
            selected = currentDestination?.hierarchy?.any { destination ->
                destination.route == BottomScreen.Row.route
            } == true,
            onClick = {
                navController.navigate(BottomScreen.Row.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
    }
}
