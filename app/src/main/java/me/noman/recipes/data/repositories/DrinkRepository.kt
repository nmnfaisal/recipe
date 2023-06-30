package me.noman.recipes.data.repositories

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import me.noman.recipes.data.local.Dao.DrinkDao
import me.noman.recipes.data.remote.response.BaseResponse
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.data.remote.response.DrinkResponse
import me.noman.recipes.data.remote.response.NetworkResult
import me.noman.recipes.data.remote.services.DrinkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DrinkRepository @Inject constructor(
    private val service: DrinkService,
    private val drinkDao: DrinkDao
) : BaseRepository() {

//    suspend fun fetchAllPosts(searchByName: String): NetworkResult<BaseResponse<DrinkResponse>> {
//        val response =
//            safeApiCall {  service.getDrinksList(searchByName)   }
//        withContext(Dispatchers.IO) {
//            if (response is NetworkResult.Success) {
//                try{
//                    val drinks = response.data!!.content!!.getDrinkResponse
////                    val drinks = response.toString()
//                    with(drinkDao) {
//                        removeAll()
////                        insert(drinks)
//                    }
//                }
//                catch (e: Exception){
//                    e.printStackTrace()
//                }
//
//            }
//        }
//        return response
//    }

//    fun fetchDrinkList(): Flow<List<Drink>> = drinkDao.getAllDrinks().flowOn(Dispatchers.IO)

    fun fetchDrinkList(): Flow<List<Drink>> {
        return drinkDao.getAllDrinks()
    }

    fun addDrinkToFavourite(idDrink: String, isFavourite: Boolean) {
        drinkDao.addToFav(idDrink, isFavourite)
    }

    fun fetchAllPosts(searchByName: String) {
        service.fetchAllPosts(searchByName).enqueue(object : Callback<DrinkResponse?> {
            override fun onResponse(
                call: Call<DrinkResponse?>,
                response: Response<DrinkResponse?>
            ) {
                Log.d("onResponse", response.body().toString())

                if (response.isSuccessful) {
                    val drinks = response.body()!!.getDrinkResponse
                    with(drinkDao) {
                        try {
                            removeAll()
                            insertDrinks(drinks)
                        }catch (e:Exception){
                            e.printStackTrace()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<DrinkResponse?>, t: Throwable) {
                Log.d("onFailure", t.toString())
            }
        })
    }
}