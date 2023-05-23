package me.noman.recipes.data.repositories

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.noman.recipes.data.remote.response.BaseResponse
import me.noman.recipes.data.remote.response.DrinkResponse
import me.noman.recipes.data.remote.response.NetworkResult
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

abstract class BaseRepository {

    suspend fun <T:Any> safeApiCall(apiCall: suspend () -> Response<BaseResponse<T>>): NetworkResult<BaseResponse<T>> {
        return withContext(Dispatchers.IO) {
            try {

                // Here we are calling api lambda
                // function that will return response
                // wrapped in Retrofit's Response class
                val response: Response<BaseResponse<T>> = apiCall()

                if (response.isSuccessful && response.body()!=null) {
                    // In case of success response we
                    // are returning NetworkResult.Success object
                    // by passing our data in it.
                    NetworkResult.Success(data = response.body()!!)
                } else {
                    // parsing api's own custom json error
                    // response in ExampleErrorResponse pojo
//                    val errorResponse: ExampleErrorResponse? = convertErrorBody(response.errorBody())
                    // Simply returning api's own failure message
                    NetworkResult.Error(errorMessage = "Response is not successful")
                }

            } catch (e: HttpException) {
                // Returning HttpException's message
                // wrapped in NetworkResult.Error
                Log.d("BaseNetworkError", e.message())
                NetworkResult.Error(errorMessage = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                // Returning no internet message
                // wrapped in NetworkResult.Error
                Log.d("BaseNetworkError", e.message.toString())
                NetworkResult.Error("Please check your network connection")
            } catch (e: Exception) {
                // Returning 'Something went wrong' in case
                // of unknown error wrapped in NetworkResult.Error
                Log.d("BaseNetworkError", e.message.toString())
                NetworkResult.Error(errorMessage = "Something went wrong")
            }
        }
    }

    private fun <T> error(errorMessage: String): NetworkResult<T> =
        NetworkResult.Error("Api call failed $errorMessage")

    // If you don't wanna handle api's own
    // custom error response then ignore this function
    private fun convertErrorBody(response: String): String {
        return try {
            val json = JSONObject(response)
            json.getString("message")
        } catch (exception: Exception) {
            return "Something went wrong"
        }
    }

    private fun <T> errorBodyToString(response: Response<T>): String {
        val reader: BufferedReader?
        val sb = StringBuilder()
        try {
            reader = BufferedReader(InputStreamReader(response.errorBody()?.byteStream()))
            var line: String?
            try {
                while (reader.readLine().also { line = it } != null) {
                    sb.append(line)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return sb.toString()
    }


}