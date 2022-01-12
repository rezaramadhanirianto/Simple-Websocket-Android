package com.froyout.websocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.froyout.websocket.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CoinsViewModel::class.java)
        viewModel.connect()
        viewModel.send("asdfasdf")
        viewModel.observe()
        viewModel.coins.observe(this, {
            println("TAG_OBSERVE: $it")
            binding.tv.text = it
        })

    }

}