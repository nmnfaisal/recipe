package me.noman.recipes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import me.noman.recipes.data.local.Dao.DrinkDao
import me.noman.recipes.data.remote.response.Drink
import javax.inject.Singleton

@Database(entities = [Drink::class], version = 1)
@Singleton
abstract class AppDatabase : RoomDatabase(){

    abstract fun drinkDao(): DrinkDao
}