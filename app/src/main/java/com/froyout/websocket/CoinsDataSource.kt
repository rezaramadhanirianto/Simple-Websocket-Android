package com.froyout.websocket

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class CoinsDataSource(val coroutineScope: CoroutineScope) {
    var mSocket: WebSocket? = null
    val socketListener = SocketManager(coroutineScope)
    fun connect(){
        val client = OkHttpClient()
        //replace x.x.x.x with your machine's IP Address
        val request: Request = Request.Builder().url("wss://demo.piesocket.com/v3/channel_1?api_key=oCdCMcMPQpbvNjUIzqtvF1d2X2okWpDQj4AwARJuAgtjhzKxVEjQU6IdCjwm&notify_self").build()
        mSocket = client.newWebSocket(request, socketListener)
    }

    fun send(str: String){
        mSocket?.send(str)
    }

    fun observeData(): Flow<String> {
        return socketListener.output.receiveAsFlow()
    }
}