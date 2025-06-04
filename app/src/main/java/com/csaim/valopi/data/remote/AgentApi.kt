package com.csaim.valopi.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AgentApi {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://valorant-api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service:AgentApiService = retrofit.create(AgentApiService::class.java)
}