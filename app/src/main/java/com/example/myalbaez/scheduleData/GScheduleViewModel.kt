package scheduleData

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.time.DayOfWeek
import java.time.LocalDate


class GScheduleViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    val today = LocalDate.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val startOfWeek = today.minusDays(today.dayOfWeek.value.toLong() - DayOfWeek.MONDAY.value.toLong())

    val scheds1 = GSdata(gsID = 1, date = 0, startTime = 9, endTime = 10, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds2 = GSdata(gsID = 2, date = 0, startTime = 10, endTime = 14, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds3 = GSdata(gsID = 3, date = 0, startTime = 14, endTime = 18, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds4 = GSdata(gsID = 4, date = 0, startTime = 18, endTime = 22, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds5 = GSdata(gsID = 5, date = 1, startTime = 9, endTime = 13, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds6 = GSdata(gsID = 6, date = 1, startTime = 13, endTime = 14, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds7 = GSdata(gsID = 7, date = 1, startTime = 14, endTime = 18, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds8 = GSdata(gsID = 8, date = 1, startTime = 18, endTime = 22, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds9 = GSdata(gsID = 9, date = 2, startTime = 9, endTime = 12, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds10 = GSdata(gsID = 10, date = 2, startTime = 12, endTime = 15, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds11 = GSdata(gsID = 11, date = 2, startTime = 15, endTime = 19, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds12 = GSdata(gsID = 12, date = 2, startTime = 19, endTime = 22, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds13 = GSdata(gsID = 13, date = 3, startTime = 9, endTime = 11, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds14 = GSdata(gsID = 14, date = 3, startTime = 11, endTime = 16, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds15 = GSdata(gsID = 15, date = 3, startTime = 16, endTime = 20, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds16 = GSdata(gsID = 16, date = 3, startTime = 20, endTime = 22, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds17 = GSdata(gsID = 17, date = 4, startTime = 9, endTime = 12, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds18 = GSdata(gsID = 18, date = 4, startTime = 12, endTime = 15, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds19 = GSdata(gsID = 19, date = 4, startTime = 15, endTime = 18, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds20 = GSdata(gsID = 20, date = 4, startTime = 18, endTime = 22, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds21 = GSdata(gsID = 21, date = 5, startTime = 9, endTime = 11, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds22 = GSdata(gsID = 22, date = 5, startTime = 11, endTime = 15, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds23 = GSdata(gsID = 23, date = 5, startTime = 15, endTime = 19, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds24 = GSdata(gsID = 24, date = 5, startTime = 19, endTime = 22, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds25 = GSdata(gsID = 25, date = 6, startTime = 9, endTime = 11, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds26 = GSdata(gsID = 26, date = 6, startTime = 11, endTime = 15, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds27 = GSdata(gsID = 27, date = 6, startTime = 15, endTime = 19, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds28 = GSdata(gsID = 28, date = 6, startTime = 19, endTime = 22, memberIDs=arrayOf(1, 2, 3), role = arrayOf("홀", "카운터", "보드"))
    val scheds: Array<GSdata> = arrayOf(scheds1,scheds2,scheds3,scheds4,scheds5,scheds6,scheds7,scheds8,scheds9,scheds10,scheds11,scheds12,scheds13,scheds14,scheds15,scheds16,scheds17,scheds18,scheds19,scheds20,scheds21,scheds22,scheds23,scheds24,scheds25,scheds26,scheds27,scheds28)
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

    fun setsched(I: GSdata){
        var num = 0
        for (j in scheds) {
            if (I == j)
                currentWorker.value = num
            num++
        }
    }

    fun getsched():GSdata{
        return scheds[currentWorker.value]
    }

    fun countRoles(): String? {
        if (scheds[currentWorker.value].role == null) return ""

        // 각 role의 등장 횟수를 세기
        val roleCountMap = scheds[currentWorker.value].role?.groupBy { it }?.mapValues { it.value.size }

        // 결과 문자열 생성
        val result = roleCountMap?.entries?.joinToString("\n") { "${it.key}${it.value}" }

        return result
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

class GScheduleViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScheduleViewModel::class.java)) {
            @Suppress("UNCHESCHED_CAST")
            return ScheduleViewModel() as T
        }
        throw IllegalAccessException("Unkown ViewModel class")
    }

}