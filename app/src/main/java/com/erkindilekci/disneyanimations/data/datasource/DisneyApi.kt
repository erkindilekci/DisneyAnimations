package com.erkindilekci.disneyanimations.data.datasource

import com.erkindilekci.disneyanimations.data.datasource.dto.AnimationDto
import retrofit2.http.GET

interface DisneyApi {
    @GET("/erkindil/Json/main/disney.json")
    suspend fun getAllAnimations(): List<AnimationDto>
}
