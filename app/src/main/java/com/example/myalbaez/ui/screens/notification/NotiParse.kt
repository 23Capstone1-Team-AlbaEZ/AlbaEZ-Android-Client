package com.example.myalbaez.ui.screens.notification

import android.content.Context
import com.example.myalbaez.ui.screens.notification.dataClass.notiDataClass
import com.google.gson.Gson
import java.io.InputStreamReader

class NotificationDataLoader(private val context: Context) {

    fun loadNotificationData(): List<notiDataClass> {
        val jsonData = context.assets.open("notificationDataWorker.json")
            .use { InputStreamReader(it).readText() }
        val gson = Gson()
        return gson.fromJson(jsonData, Array<notiDataClass>::class.java).toList()
    }
    fun loadManagerNotificationData(): List<notiDataClass> {
        val jsonData = context.assets.open("notificationDataManager.json")
            .use { InputStreamReader(it).readText() }
        val gson = Gson()
        return gson.fromJson(jsonData, Array<notiDataClass>::class.java).toList()
    }
}