package com.uc.alpvp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alpvp.model.Data
import com.uc.alpvp.repository.ListsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor(private val repository: ListsRepository): ViewModel() {

    // get lists data
    val _lists: MutableLiveData<ArrayList<Data>> by lazy {
        MutableLiveData<ArrayList<Data>>()
    }

    val lists: LiveData<ArrayList<Data>>
    get() = _lists

    fun getLists() = viewModelScope.launch {
        repository.getListsData().let {
            response->
            if (response.isSuccessful){
                _lists.postValue(response.body()?.data as ArrayList<Data>?)
            }else{
                Log.e("Get Data", "Failed")
            }
        }
    }
}