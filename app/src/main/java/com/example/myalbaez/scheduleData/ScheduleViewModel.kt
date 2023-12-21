package com.example.myalbaez.scheduleData

import android.app.Application
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import scheduleData.PSdata
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class ScheduleViewModel() : ViewModel() {

    val today = LocalDate.now()
    val startOfWeek = today.minusDays(today.dayOfWeek.value.toLong() - DayOfWeek.MONDAY.value.toLong())

    val dateList = mutableListOf<String>()

    fun setWeek() {
        repeat(7) {
            val date = startOfWeek.plusDays(it.toLong())
            val formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            dateList.add(formattedDate)
        }
    }
    var currentWorker: MutableState<Int> = mutableStateOf(0)

    /*var scheds=getJsonData(application.applicationContext,"PersonalScheduleData.json")*/
    val scheds1 = PSdata(workplace = "맥도날드 숭실대점", psID = 1, date = 0, startTime = 10, endTime = 14, role = "홀")
    val scheds2 = PSdata(workplace = "맥도날드 숭실대점", psID = 2, date = 1, startTime = 14, endTime = 17, role = "홀")
    val scheds3 = PSdata(workplace = "백다방 숭실대점", psID = 3, date = 2, startTime = 16, endTime = 21, role = "주방")
    val scheds4 = PSdata(workplace = "맥도날드 숭실대점", psID = 4, date = 3, startTime = 11, endTime = 15, role = "홀")
    val scheds5 = PSdata(workplace = "맥도날드 숭실대점", psID = 5, date = 4, startTime = 9, endTime = 14, role = "홀")
    val scheds: Array<PSdata> = arrayOf(scheds1,scheds2,scheds3,scheds4,scheds5)

    fun nextWorker() {
        currentWorker.value += 1
        if (currentWorker.value == scheds.size)
            currentWorker.value = 0
    }

    fun prevWorker() {
        currentWorker.value -= 1
        if (currentWorker.value < 0)
            currentWorker.value = scheds.size - 1
    }

    fun setsched(I: PSdata){
        var num = 0
        for (j in scheds) {
            if (I == j)
                currentWorker.value = num
            num++
        }
    }

    fun getsched(): PSdata {
        return scheds[currentWorker.value]
    }


    /*fun getJsonData(context: Context, fileName:String):List<PSdata>{
        val gson = Gson()
        val jsonData = context.assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
        return gson.fromJson(jsonData, Array<PSdata>::class.java).toList()
    }*/
}

/*
class ScheduleViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            @Suppress("UNCHESCHED_CAST")
            return ScheduleViewModel(application = ) as T
        }
        throw IllegalAccessException("Unkown ViewModel class")
    }

}*/
