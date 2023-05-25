package com.erkindilekci.disneyanimations.presentation.detailscreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.erkindilekci.disneyanimations.R
import com.erkindilekci.disneyanimations.presentation.ui.theme.myBackgroundColor
import com.erkindilekci.disneyanimations.presentation.util.ErrorScreen
import com.erkindilekci.disneyanimations.presentation.util.LoadingScreen

@Composable
fun AnimationDetailScreen(
    id: Int,
    navController: NavController,
    viewModel: AnimationDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    val scrollState = rememberScrollState()

    LaunchedEffect(id) {
        viewModel.getSelectedAnimation(id)
    }

    state.animation?.let { animation ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.myBackgroundColor)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            ) {
                AsyncImage(
                    model = animation.poster,
                    contentDescription = animation.name,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.loading_img)
                )
            }

            Text(
                text = animation.name,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 12.dp, top = 12.dp, bottom = 10.dp),
                fontWeight = FontWeight.Medium
            )

            Text(
                text = animation.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 12.dp, end = 12.dp, bottom = 16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }

    if (state.error.isNotBlank()) {
        ErrorScreen(error = state.error)
    }
    if (state.isLoading) {
        LoadingScreen()
    }

    BackHandler {
        navController.navigateUp()
    }
}
