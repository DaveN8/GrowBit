package com.uc.alpvp.repository

import com.uc.alpvp.retrofit.EndPointApi
import javax.inject.Inject

class ListsRepository @Inject constructor(private val api: EndPointApi){
    suspend fun getListsData() =
        api.getLists()
}