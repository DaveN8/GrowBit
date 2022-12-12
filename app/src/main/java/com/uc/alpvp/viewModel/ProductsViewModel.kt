package com.uc.alpvp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alpvp.model.Data
import com.uc.alpvp.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val repository: ProductsRepository): ViewModel() {

    // get products data
    val _products: MutableLiveData<ArrayList<Data>> by lazy {
        MutableLiveData<ArrayList<Data>>()
    }

    val products: LiveData<ArrayList<Data>>
    get() = _products

    fun getProducts() = viewModelScope.launch {
        repository.getProductsData().let {
            response ->
            if (response.isSuccessful){
                _products.postValue(response.body()?.data as ArrayList<Data>?)
            }else{
                Log.e("Get Data", "Failed")
            }
        }
    }
}