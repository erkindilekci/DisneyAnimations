package com.erkindilekci.disneyanimations.presentation.detailscreen

import com.erkindilekci.disneyanimations.domain.model.Animation

data class AnimationDetailScreenState(
    val isLoading: Boolean = false,
    val animation: Animation? = null,
    val error: String = ""
)
