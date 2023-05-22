package me.noman.recipes.core.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.noman.recipes.data.local.AppDatabase
import me.noman.recipes.data.local.Dao.DrinkDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDao(
        @ApplicationContext appContext
        : Context
    ): AppDatabase {
        val dbInstance = Room.databaseBuilder<AppDatabase>(
            appContext, AppDatabase::class.java, "RecipeDatabase"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        return dbInstance
    }

    @Provides
    @Singleton
    fun provideDrinkDao(appDatabase: AppDatabase): DrinkDao {
        return appDatabase.drinkDao()
    }
}