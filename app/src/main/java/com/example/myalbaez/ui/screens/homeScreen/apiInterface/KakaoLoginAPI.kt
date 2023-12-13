package com.example.myalbaez.ui.screens.homeScreen.apiInterface

import com.example.myalbaez.ui.screens.homeScreen.dataClass.KakaoLoginRequest
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Body

interface KakaoLoginAPI {

    @POST("api/auth/kakao")
    fun postKakaoAuthCode(
        @Body authorizationCodeObeject: KakaoLoginRequest
    ): Call<KakaoLoginRequest>


}