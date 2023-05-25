package com.erkindilekci.disneyanimations.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val CardColor = Color(0xFF141414)
val CardColorLight = Color(0xFFFFFDFA)

val BackgroundColor = Color(0xFF000000)
val BackgroundColorLight =  Color(0xFFF7F7F7)


val MaterialTheme.myCardColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) CardColor else CardColorLight

val MaterialTheme.myBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) BackgroundColor else BackgroundColorLight