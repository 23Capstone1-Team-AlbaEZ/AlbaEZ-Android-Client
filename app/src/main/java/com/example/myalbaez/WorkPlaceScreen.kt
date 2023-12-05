package com.example.myalbaez

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myalbaez.ui.theme.MyAlbaEzTheme

class WorkPlaceScreen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAlbaEzTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    ) {


                    Schedule()
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                    ) {
                        MyCard()
                    }
                }

            }
        }
    }
}


@Composable
fun Schedule(
    viewModel: ScheduleViewModel = viewModel()
) {
    val wpStartTime = viewModel.workplace.startTime
    val wpEndTime = viewModel.workplace.endTime


    val wStartTime = viewModel.worker1.startTime
    val wEndTime = viewModel.worker1.endTime
    val wDate = viewModel.worker1.date
    val worker = viewModel.array1

    Log.v("test", worker[1].date.toString() + "hellosong")

    var state = 0

    val context = LocalContext.current

    val scrollState = rememberScrollState()


    Box(
        modifier = Modifier
            //.width(300.dp)
            .height(2000.dp)
            .verticalScroll(scrollState)
            .background(color = Color(0xFFFFFAFA))
    ) {
        Column(
            modifier = Modifier
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                modifier = Modifier
                    .width(64.dp)
                    .height(30.dp),
                text = "내 일정",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight(700),
                color = Color(0xFF5B5B5B),
                letterSpacing = 0.4.sp,
            )
            Row(
                modifier = Modifier
                    .width(296.dp)
                    .height(40.dp)
                    .padding(start = 50.dp, top = 10.dp, end = 8.dp, bottom = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = "월",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "화",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "수",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "목",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "금",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "토",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "일",
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                    textAlign = TextAlign.Center,

                    )
            }
            Row(
                modifier = Modifier
                    .width(400.dp)
                    .height((25 * 36).dp)
                    .padding(start = 0.dp, top = 0.dp, end = 8.dp, bottom = 10.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Column(
                    modifier = Modifier
                        .width(38.dp)
                        .height(((wpEndTime!!.minus(wpStartTime!!) + 1) * 36).dp)
                        .padding(start = 0.dp, top = 0.dp, end = 5.dp, bottom = 0.dp),
                    //verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (wpStartTime != null) {
                        for (i: Int in wpStartTime..wpEndTime!!) {
                            Text(
                                modifier = Modifier
                                    .width(266.dp)
                                    .height(36.dp)
                                    .padding(top = 12.dp),
                                text = i.toString(),
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.Transparent)
                        .width(266.dp)
                        .height(((wpEndTime!!.minus(wpStartTime!!) + 1) * 36).dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    if (wpStartTime != null) {
                        if (wpEndTime != null) {
                            for (i: Int in wpStartTime..(wpEndTime)!!) {
                                Row(
                                    modifier = Modifier
                                        .width(266.dp)
                                        .height(35.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    for (i: Int in 1..6)
                                        Divider(
                                            modifier = Modifier
                                                .width(1.dp)
                                                .fillMaxHeight(), color = Color.Transparent
                                        )
                                }
                                Divider(
                                    modifier = Modifier
                                        .height(1.dp),
                                    color = Color.Transparent
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .width(266.dp)
                            .height(36.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        for (i: Int in 1..6)
                            Divider(
                                modifier = Modifier
                                    .width(1.dp)
                                    .fillMaxHeight(), color = Color.Transparent
                            )

                    }
                }
            }
        }
        for (i in worker)
            Box(
                modifier = Modifier
                    //.padding(start = (69+wDate!!*38).dp, top = (101 + (wStartTime!!.minus(wpStartTime!!)) * 36).dp)
                    .padding(
                        start = (69 + i.date!! * 38).dp,
                        top = (101+(i.startTime!!.minus(wpStartTime!!)) * 36).dp
                    )
            ) {
                Box(modifier = Modifier
                    .width(36.dp)
                    //.height((((wEndTime!!.minus(wStartTime!!)) * 36)).dp)
                    .height((((i.endTime!!.minus(i.startTime!!)) * 36)).dp)
                    .background(color = Color.Transparent, shape = RoundedCornerShape(size = 2.dp))
                    .padding(start = 1.dp, top = 1.dp, end = 1.dp, bottom = 1.dp)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "${i.startTime}~${i.endTime}",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Variables.getColor(),
                            shape = RoundedCornerShape(size = 3.dp)
                        )
                    ){}
                }
            }

    }
}
object Variables {
    val calendar_gray: Color = Color(0xFFE1E1E1)
    val calendar_pink: Color = Color(0xFFFFE4E4)
    val calendar_purple: Color = Color(0xFFECE0FF)
    val calendar_blue: Color = Color(0xFFDBE7FF)
    val calendar_orange: Color = Color(0x85FFCE84)
    val calendar_green: Color = Color(0xFFD8EDDB)
    val calendar_colors: Array<Color> = arrayOf(calendar_gray, calendar_pink, calendar_purple, calendar_blue, calendar_orange, calendar_green)
    var nowColor = 0

    fun getColor(): Color {
        nowColor ++
        if(nowColor==6)
            nowColor = 0
        return calendar_colors[nowColor]
    }
}


@Composable
fun MyCard(
) {
    val viewModel = viewModel<ScheduleViewModel>()
    Column(
        verticalArrangement = Arrangement.Bottom,
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .height(250.dp)
                .padding(start = 30.dp, top = 25.dp),
        ) {
            Text(text = "${viewModel.array1[viewModel.currentWorker.value].startTime.toString()}")
            Button(modifier = Modifier
                .align(Alignment.BottomEnd),
                onClick = {
                    viewModel.nextWorker()
                }) {
                Text(text = "next")

            }
        }
    }

}

data class Worker(
    val date: Int? = null,
    val startTime: Int? = null,
    val endTime: Int? = null,
)

data class Workplace(
    val startTime: Int? = null,
    val endTime: Int? = null,
)


class ScheduleViewModel : ViewModel() {

    val workplace = Workplace(startTime = 9, endTime = 22)
    val worker1 = Worker(date = 6, startTime = 10, endTime = 15)
    val worker2 = Worker(date = 1, startTime = 9, endTime = 12)
    val worker3 = Worker(date = 4, startTime = 15, endTime = 22)


    val array1: Array<Worker> = arrayOf(worker1, worker2, worker3)
    val array2: Array<Workplace> = emptyArray()

    var currentWorker: MutableState<Int> = mutableIntStateOf(0)

    fun nextWorker(){
        currentWorker.value += 1
        if(currentWorker.value==array1.size)
            currentWorker.value = 0
    }

}

class CardViewModel : ViewModel() {

    val array1: Array<Worker> = emptyArray()
    val array2: Array<Workplace> = emptyArray()

    val worker1 = Worker(startTime = 10, endTime = 15)
    val worker2 = Worker(startTime = 9, endTime = 12)
    val worker3 = Worker(startTime = 15, endTime = 22)


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


@Preview
@Composable
fun previewSchedule() {
    Schedule()
}

