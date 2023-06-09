package me.noman.recipes.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.data.remote.response.DrinkResponse

@Dao
interface DrinkDao{

    @Query("SELECT * FROM DRINK")
    fun getAllDrinks(): Flow<List<Drink>>

    @Query("DELETE FROM DRINK")
    fun removeAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDrinks(drinks: List<Drink>)
}