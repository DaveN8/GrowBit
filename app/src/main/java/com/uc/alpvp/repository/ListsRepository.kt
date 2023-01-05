package com.uc.alpvp.repository

import com.uc.alpvp.retrofit.EndPointApi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class ListsRepository @Inject constructor(private val api: EndPointApi){
    suspend fun getListsData() =
        api.getLists()

    suspend fun createListsData(
        list_title: String,
        list_desc: String,
        list_note: String,
        list_set_time: String,
        list_set_date: String,
    ){
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("title", list_title)
            .addFormDataPart("description", list_desc)
            .addFormDataPart("note", list_note)
            .addFormDataPart("set_time", list_set_time)
            .addFormDataPart("set_date", list_set_date)
            .build()

        api.createLists(requestBody)
    }

}