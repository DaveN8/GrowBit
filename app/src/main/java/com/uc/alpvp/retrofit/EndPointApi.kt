package com.uc.alpvp.retrofit

import com.uc.alpvp.model.Data
import com.uc.alpvp.model.Lists
import retrofit2.Response
import retrofit2.http.GET

interface EndPointApi {
    @GET("lists")
    suspend fun getLists():Response<Lists>

}