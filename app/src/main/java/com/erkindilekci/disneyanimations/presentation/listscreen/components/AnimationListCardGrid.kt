package com.erkindilekci.disneyanimations.presentation.listscreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.erkindilekci.disneyanimations.R
import com.erkindilekci.disneyanimations.domain.model.Animation
import com.erkindilekci.disneyanimations.presentation.ui.theme.myCardColor

@Composable
fun AnimationListCardGrid(
    animation: Animation,
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(4.dp, MaterialTheme.myCardColor)
    ) {
        Column(
            modifier = Modifier
                .size(180.dp, 320.dp)
                .background(MaterialTheme.myCardColor)
                .clickable { onItemClicked(animation.id) },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp, 230.dp)
                    .background(MaterialTheme.myCardColor)
                    .padding(top = 15.dp)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                AsyncImage(
                    model = animation.poster,
                    contentDescription = animation.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.loading_img)
                )
            }

            Text(
                text = animation.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )

            Text(
                text = animation.playtime,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 15.dp)
            )
        }
    }
}
