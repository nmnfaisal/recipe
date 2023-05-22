package me.noman.recipes.core.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.noman.recipes.data.remote.services.DrinkService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServicesModule {


    @Singleton
    @Provides
    fun providesDrinkAPI(retrofit: Retrofit) : DrinkService{
        return retrofit.create(DrinkService::class.java)
    }

}