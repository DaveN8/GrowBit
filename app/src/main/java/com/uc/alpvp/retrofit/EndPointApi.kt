package com.uc.alpvp.retrofit

import com.uc.alpvp.model.Data
import com.uc.alpvp.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface EndPointApi {
    @GET("products")
    suspend fun getProducts():Response<Products>
}