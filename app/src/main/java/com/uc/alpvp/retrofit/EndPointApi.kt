package com.uc.alpvp.retrofit

import com.uc.alpvp.model.Data
import com.uc.alpvp.model.GetInputLogin
import com.uc.alpvp.model.Lists
import com.uc.alpvp.model.User
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface EndPointApi {
    //lists
    @GET("lists")
    suspend fun getLists():Response<Lists>
    @POST("lists/create")
    suspend fun createLists(@Body body: RequestBody?): ResponseBody?

    //user
    @FormUrlEncoded
    @POST("login")
    fun checkLogin(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<GetInputLogin>

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<User>
}