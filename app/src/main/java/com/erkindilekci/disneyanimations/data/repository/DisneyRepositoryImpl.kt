package com.erkindilekci.disneyanimations.data.repository

import com.erkindilekci.disneyanimations.data.datasource.DisneyApi
import com.erkindilekci.disneyanimations.domain.model.Animation
import com.erkindilekci.disneyanimations.domain.repository.DisneyRepository
import com.erkindilekci.disneyanimations.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DisneyRepositoryImpl @Inject constructor(
    private val api: DisneyApi
) : DisneyRepository{

    override fun getAllAnimations(): Flow<Resource<List<Animation>>> {
        return flow {
            try {
                emit(Resource.Loading<List<Animation>>())
                val animations = api.getAllAnimations().map { it.toAnimation() }
                emit(Resource.Success<List<Animation>>(animations))
            } catch (e: HttpException) {
                emit(Resource.Error<List<Animation>>(e.localizedMessage ?: "An unknown error occurred!"))
            } catch (e: IOException) {
                emit(Resource.Error<List<Animation>>("Please check your internet connection."))
            }
        }
    }

    override fun getSelectedAnimation(id: Int): Flow<Resource<Animation>> {
        return flow {
            try {
                emit(Resource.Loading<Animation>())
                val animation = api.getAllAnimations().map { it.toAnimation() }.filter { it.id == id}.first()
                emit(Resource.Success<Animation>(animation))
            } catch (e: HttpException) {
                emit(Resource.Error<Animation>(e.localizedMessage ?: "An unknown error occurred!"))
            } catch (e: IOException) {
                emit(Resource.Error<Animation>("Please check your internet connection."))
            }
        }
    }
}
