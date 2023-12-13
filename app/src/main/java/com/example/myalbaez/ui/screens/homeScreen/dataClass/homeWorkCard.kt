package com.example.myalbaez.ui.screens.homeScreen.dataClass

import com.google.gson.annotations.SerializedName

data class homeWorkCard(
    @SerializedName("workplaceName") val workplaceName: String,
    @SerializedName("scheduleList") val scheduleList: List<workData>
){
    data class workData(
        @SerializedName("scheduleId") val scheduleId: Int,
        @SerializedName("memberID") val memberId: Int,
        @SerializedName("week") val week: Int,
        @SerializedName("day") val day: String,
        @SerializedName("startTime") val startTime: String,
        @SerializedName("endTime") val endTime: String
    )
}




