package com.example.jetpacktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved : Int) : ViewModel() {
    val counter : LiveData<Int>
       get() = _counter
    private val _counter = MutableLiveData<Int>()
    init{
        _counter.value = countReserved
    }
    fun plusOne(){
        val count = _counter.value?: 0
        _counter.value = count+1
    }
    fun clear(){
        _counter.value = 0
    }
    private val userIdLiveData = MutableLiveData<String>()

    val user : LiveData<User> = Transformations.switchMap(userIdLiveData){
        userId -> Repository.getUser(userId)
    }
    fun getUser(userId : String){
        userIdLiveData.value = userId
    }

}