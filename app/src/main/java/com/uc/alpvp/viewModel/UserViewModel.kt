package com.uc.alpvp.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc.alpvp.model.Data
import com.uc.alpvp.model.DataX
import com.uc.alpvp.model.User
import com.uc.alpvp.repository.ListsRepository
import com.uc.alpvp.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UsersRepository): ViewModel(){



    fun Login(username: String, password: String) = repository.Login(username,password)

    // get user data to register
    val _regis: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    val regis: LiveData<User>
        get() = _regis

    fun createUser(Users: DataX) = viewModelScope.launch {
    repository.register(Users).let { response ->
        if (response.isSuccessful){
                _regis.postValue(
                    response.body() as User
                )
            }else{
                Log.e("Create Data", "Failed!")
            }
        }
    }

}