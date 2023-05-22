package me.noman.recipes.data.remote.response

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : NetworkResult<T>(data)

    class Error<T>(errorMessage: String?, data: T? = null) : NetworkResult<T>(data, errorMessage)

    class Loading<T> : NetworkResult<T>()

}