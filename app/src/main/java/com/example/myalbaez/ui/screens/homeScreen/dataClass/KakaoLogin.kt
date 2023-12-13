package com.example.myalbaez.ui.screens.homeScreen.dataClass

import com.google.gson.annotations.SerializedName

data class KakaoLoginRequest(
    @SerializedName("authorizationCode") var authorizationCode: String
)

data class KakaoLoginResponse(
    @SerializedName("accessToken") val accessToken : String,
    @SerializedName("refreshToken") val refreshToken : String,
    @SerializedName("grantType") val grantType : String,
    @SerializedName("expiresIn") val expiresIn : Int
)
