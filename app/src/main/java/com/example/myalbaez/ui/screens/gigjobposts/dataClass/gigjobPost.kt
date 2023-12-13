package com.example.myalbaez.ui.screens.gigjobposts.dataClass

import com.google.gson.annotations.SerializedName
data class gigjobPost(
    @SerializedName("gigjobPostID") val gigjobPostID: Int,
    @SerializedName("scheduleAdjustID") val scheduleAdjustID: Int,
    @SerializedName("workplaceName") val workplaceName: String,
    @SerializedName("address") val address: String,
    @SerializedName("content") val content: String,
    @SerializedName("payForm") val payForm:String,
    @SerializedName("pay") val pay:String,
    @SerializedName("day") val day: String,
    @SerializedName("startTime") val startTime: String,
    @SerializedName("endTime")  val endTime: String,
    @SerializedName("postDate") val postDate: String,
    @SerializedName("expirationDate") val expirationDate: String
)
