package me.noman.recipes.data.remote.response

import kotlinx.serialization.Serializable


@Serializable
data class BaseResponse<T:Any>(val content:T?)
