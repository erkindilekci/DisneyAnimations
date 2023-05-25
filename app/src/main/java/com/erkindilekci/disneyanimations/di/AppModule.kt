package com.erkindilekci.disneyanimations.di

import com.erkindilekci.disneyanimations.data.datasource.DisneyApi
import com.erkindilekci.disneyanimations.data.repository.DisneyRepositoryImpl
import com.erkindilekci.disneyanimations.domain.repository.DisneyRepository
import com.erkindilekci.disneyanimations.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDisneyApi(): DisneyApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DisneyApi::class.java)

    @Provides
    @Singleton
    fun provideDisneyRepository(api: DisneyApi): DisneyRepository = DisneyRepositoryImpl(api)
}
