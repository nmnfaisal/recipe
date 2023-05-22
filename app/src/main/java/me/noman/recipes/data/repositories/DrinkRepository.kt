package me.noman.recipes.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import me.noman.recipes.data.local.Dao.DrinkDao
import me.noman.recipes.data.remote.response.BaseResponse
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.data.remote.response.DrinkResponse
import me.noman.recipes.data.remote.response.NetworkResult
import me.noman.recipes.data.remote.services.DrinkService
import javax.inject.Inject

class DrinkRepository @Inject constructor(
    private val service: DrinkService,
    private val drinkDao: DrinkDao
) : BaseRepository() {

//    fun getDrinkList(accountId: String): Flow<Drink> {
//        return dao.getAccountDetails(accountId)
//    }
//
//    fun getDrinkList(accountId: String): Drink {
//        return dao.getAccountDetail(accountId)
//    }

    suspend fun getDrinkList(searchByName: String) = withContext(Dispatchers.IO) {
        val response: NetworkResult<BaseResponse<DrinkResponse>> = safeApiCall { service.getDrinksList(searchByName)  }

        withContext(Dispatchers.IO) {
            if (response is NetworkResult.Success) {
                try {
                    val drinks = response.data!!.content!!.getDrinkResponse
                    with(drinkDao) {
                        insertDrinks(drinks)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}