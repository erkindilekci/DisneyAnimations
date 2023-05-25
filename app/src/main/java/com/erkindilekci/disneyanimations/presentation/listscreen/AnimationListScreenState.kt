package com.erkindilekci.disneyanimations.presentation.listscreen

import com.erkindilekci.disneyanimations.domain.model.Animation

data class AnimationListScreenState(
    val isLoading: Boolean = false,
    val animations: List<Animation> = emptyList(),
    val error: String = ""
)
