package com.erkindilekci.disneyanimations.presentation.listscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.erkindilekci.disneyanimations.R
import com.erkindilekci.disneyanimations.presentation.listscreen.components.AnimationListBottomBar
import com.erkindilekci.disneyanimations.presentation.ui.theme.myBackgroundColor
import com.erkindilekci.disneyanimations.presentation.util.AnimationListScreenNavigation
import com.erkindilekci.disneyanimations.presentation.util.AppScreen
import com.erkindilekci.disneyanimations.presentation.util.ErrorScreen
import com.erkindilekci.disneyanimations.presentation.util.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimationListScreen(
    viewModel: AnimationListViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value
    val bottomNavController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .background(MaterialTheme.myBackgroundColor),
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(46.dp)
                            .background(MaterialTheme.myBackgroundColor)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.disney_icon),
                            contentDescription = stringResource(R.string.disney),
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .height(46.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.myBackgroundColor)
            )
        },
        content = { padding ->
            AnimationListScreenNavigation(
                navController = bottomNavController,
                animations = state.animations,
                padding = padding,
                onItemClicked = { id ->
                    navController.navigate("${AppScreen.DetailScreen.route}/$id")
                }
            )
            if (state.error.isNotBlank()) {
                ErrorScreen(error = state.error)
            }
            if (state.isLoading) {
                LoadingScreen()
            }
        },
        bottomBar = {
            AnimationListBottomBar(navController = bottomNavController)
        }
    )
}
