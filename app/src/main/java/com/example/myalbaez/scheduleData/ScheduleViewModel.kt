package scheduleData

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class ScheduleViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    val today = LocalDate.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val startOfWeek = today.minusDays(today.dayOfWeek.value.toLong() - DayOfWeek.MONDAY.value.toLong())

    val dateList = mutableListOf<String>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun setWeek() {
        repeat(7) {
            val date = startOfWeek.plusDays(it.toLong())
            val formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            dateList.add(formattedDate)
        }
    }

    val scheds1 = PSdata(workplace = "맥도날드 숭실대점", psID = 1, date = 0, startTime = 9, endTime = 14, role = "홀")
    val scheds2 = PSdata(workplace = "맥도날드 숭실대점", psID = 2, date = 1, startTime = 16, endTime = 21, role = "홀")
    val scheds3 = PSdata(workplace = "백다방 숭실대점", psID = 3, date = 2, startTime = 9, endTime = 12, role = "카운터")
    val scheds4 = PSdata(workplace = "맥도날드 숭실대점", psID = 4, date = 3, startTime = 16, endTime = 21, role = "홀")
    val scheds5 = PSdata(workplace = "맥도날드 숭실대점", psID = 5, date = 4, startTime = 9, endTime = 14, role = "홀")
    val scheds: Array<PSdata> = arrayOf(scheds1,scheds2,scheds3,scheds4,scheds5)
    var currentWorker: MutableState<Int> = mutableStateOf(0)

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

    fun getsched():PSdata{
        return scheds[currentWorker.value]
    }

    /*
    val workplace = Workplace(startTime = 9, endTime = 22)
    val worker1 = Worker(date = 6, startTime = 10, endTime = 15)
    val worker2 = Worker(date = 1, startTime = 9, endTime = 12)
    val worker3 = Worker(date = 4, startTime = 15, endTime = 22)


    val array1: Array<Worker> = arrayOf(worker1, worker2, worker3)
    val array2: Array<Workplace> = emptyArray()

    var currentWorker: MutableState<Int> = mutableStateOf(0)

    fun nextWorker() {
        currentWorker.value += 1
        if (currentWorker.value == array1.size)
            currentWorker.value = 0
    }

    fun prevWorker() {
        currentWorker.value -= 1
        if (currentWorker.value < 0)
            currentWorker.value = array1.size - 1
    }
*/
}

class ScheduleViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            @Suppress("UNCHESCHED_CAST")
            return ScheduleViewModel() as T
        }
        throw IllegalAccessException("Unkown ViewModel class")
    }

}