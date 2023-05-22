package me.noman.recipes.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.data.remote.response.DrinkResponse

@Dao
interface DrinkDao  : BaseDao<Drink>{
//    @Query("SELECT * FROM accountdetails where accountID = :account_id")
//    fun getAccountDetails(account_id: String): Flow<AccountDetails>
//
//    @Query("SELECT * FROM accountdetails where accountID = :account_id")
//    fun getAccountDetail(account_id: String): AccountDetails

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDrinks(drinks: ArrayList<DrinkResponse>)
}