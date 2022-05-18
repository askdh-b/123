package com.example.mobile_02_06.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://smarthome.madskill.ru/"

class API {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object {
        val mInstance = API()
    }

    val mSettings: NetworkService = retrofit.create(NetworkService::class.java)
}