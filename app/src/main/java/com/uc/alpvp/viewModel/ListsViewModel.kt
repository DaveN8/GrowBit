package com.uc.alpvp.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alpvp.model.Data
import com.uc.alpvp.model.GetInput
import com.uc.alpvp.repository.ListsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor(private val repository: ListsRepository): ViewModel() {

    var deta by mutableStateOf(GetInput())

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

    // get lists data by id
    val _listsbyid: MutableLiveData<ArrayList<Data>> by lazy {
        MutableLiveData<ArrayList<Data>>()
    }

    val listsbyid: LiveData<ArrayList<Data>>
        get() = _listsbyid

    fun getListsbyId(u_id: Int) = viewModelScope.launch {
        repository.getListsbyId(u_id).let {
                response->
            if (response.isSuccessful){
                _listsbyid.postValue(response.body()?.data as ArrayList<Data>)
            }else{
                Log.e("Get Data", "Failed")
            }
        }
    }

    fun deleteLis(l_id: Int) = viewModelScope.launch {
        repository.deleteLis(l_id)
    }

    fun createList() = viewModelScope.launch {
        repository.createListsData(
            list_title = deta.title,
            list_desc = deta.description,
            list_note = deta.note,
            list_set_time = deta.set_time,
            list_set_date = deta.set_date,
            list_user_id = deta.user_id
        )
    }
}