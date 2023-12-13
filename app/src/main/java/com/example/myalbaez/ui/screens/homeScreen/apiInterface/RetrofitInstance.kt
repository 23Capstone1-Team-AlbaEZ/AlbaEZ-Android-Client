package com.example.myalbaez.ui.screens.homeScreen.apiInterface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://54.180.33.58/"

    val retrofit:Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginService:KakaoLoginAPI by lazy{
        retrofit.create(KakaoLoginAPI::class.java)
    }
}