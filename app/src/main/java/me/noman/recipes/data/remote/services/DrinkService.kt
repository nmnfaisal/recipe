package me.noman.recipes.data.remote.services

import me.noman.recipes.data.remote.response.BaseResponse
import me.noman.recipes.data.remote.response.Drink
import me.noman.recipes.data.remote.response.DrinkResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DrinkService {

    @GET("api/json/v1/1/search.php")
    suspend fun getDrinksList(@Query("s") searchByName: String): Response<BaseResponse<DrinkResponse>>

    @GET("api/json/v1/1/search.php")
    fun fetchAllPosts(@Query("s") searchByName: String): Call<DrinkResponse>

}