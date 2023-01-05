package com.uc.alpvp.repository

import com.uc.alpvp.model.DataX
import com.uc.alpvp.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class UsersRepository @Inject constructor(private val api: EndPointApi){

    fun Login(
        user_username: String,
        user_password: String,
    ) = api.checkLogin(user_username, user_password)

    suspend fun register(c: DataX) = api.register(c.username, c.email, c.password)
}