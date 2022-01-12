package com.froyout.websocket

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class CoinsRepository(val coroutineScope: CoroutineScope) {
    val dataSource = CoinsDataSource(coroutineScope)
    fun connect(){
       dataSource.connect()
    }

    fun send(str: String){
        dataSource.send(str)
    }

    fun observeData(): Flow<String> {
        return dataSource.observeData()
    }
}