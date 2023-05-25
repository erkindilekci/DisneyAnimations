package com.erkindilekci.disneyanimations.domain.repository

import com.erkindilekci.disneyanimations.domain.model.Animation
import com.erkindilekci.disneyanimations.util.Resource
import kotlinx.coroutines.flow.Flow

interface DisneyRepository {
    fun getAllAnimations(): Flow<Resource<List<Animation>>>

    fun getSelectedAnimation(id: Int): Flow<Resource<Animation>>
}
