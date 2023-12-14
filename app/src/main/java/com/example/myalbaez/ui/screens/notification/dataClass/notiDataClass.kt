package com.example.myalbaez.ui.screens.notification.dataClass

import com.google.gson.annotations.SerializedName
data class notiDataClass(
    @SerializedName("alarmID") val alarmID: Int,
    @SerializedName("userID") val userID: Int,
    @SerializedName("workplaceID") val workplaceID: Int,
    @SerializedName("status") val status: Boolean,
    @SerializedName("adjustDate") val adjustDate: String,
    @SerializedName("person") val person: String,
    @SerializedName("startTime") val startTime: String,
    @SerializedName("content") val content: String
)