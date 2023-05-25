package com.erkindilekci.disneyanimations.data.datasource.dto

import com.erkindilekci.disneyanimations.domain.model.Animation

data class AnimationDto(
    val description: String,
    val id: Int,
    val name: String,
    val playtime: String,
    val poster: String,
    val release: String
) {
    fun toAnimation(): Animation = Animation(description, id, name, playtime, poster, release)
}
