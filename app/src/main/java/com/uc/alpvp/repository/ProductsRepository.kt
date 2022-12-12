package com.uc.alpvp.repository

import com.uc.alpvp.retrofit.EndPointApi
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val api: EndPointApi){
    suspend fun getProductsData() =
        api.getProducts()
}