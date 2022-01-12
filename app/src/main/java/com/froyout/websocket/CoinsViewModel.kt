package com.froyout.websocket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CoinsViewModel: ViewModel() {
    var coins : MutableLiveData<String> = MutableLiveData()
    val repo = CoinsRepository(viewModelScope)


    fun connect(){
        repo.connect()
    }

    fun send(str: String){
        repo.send(str)
    }

    fun observe(){
        viewModelScope.launch {
            repo.observeData().collect{
                coins.value = it
            }
        }
    }
}