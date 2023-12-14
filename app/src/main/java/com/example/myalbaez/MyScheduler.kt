package com.example.myalbaez

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.example.myalbaez.ui.Reschedule
import com.example.myalbaez.ui.screens.gigjobposts.GigjobPostsActivity
import com.example.myalbaez.ui.theme.MyAlbaEzTheme
import scheduleData.PSdata
import scheduleData.ScheduleViewModel

class MyScheduler : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAlbaEzTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
    val schedule = viewModel


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
                        .height((14 * 36).dp)
                        .padding(start = 0.dp, top = 0.dp, end = 5.dp, bottom = 0.dp),
                    //verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (true) {
                        for (i: Int in 9..22) {
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
                        .border(width = 1.dp, color = Color(0xFF333333))
                        .width(266.dp)
                        .height((14 * 36).dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    if (true) {
                        if (true) {
                            for (i: Int in 9..22) {
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
                                                .fillMaxHeight(), color = Color.Black
                                        )
                                }
                                Divider(
                                    modifier = Modifier
                                        .height(1.dp),
                                    color = Color.Black
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
                                    .fillMaxHeight(), color = Color.Black
                            )

                    }
                }
            }
        }
        for (i in viewModel.scheds)
            Box(
                modifier = Modifier
                    //.padding(start = (69+wDate!!*38).dp, top = (101 + (wStartTime!!.minus(wpStartTime!!)) * 36).dp)
                    .padding(
                        start = (69 + i.date!! * 38).dp,
                        //top = (101+(i.endTime!!.minus(i.startTime!!)) * 36).dp
                        top = (101 + (i.startTime!!-9) * 36).dp
                    )
            ) {
                Box(modifier = Modifier
                    .width(36.dp)
                    //.height((((wEndTime!!.minus(wStartTime!!)) * 36)).dp)
                    .height((((i.endTime!!.minus(i.startTime!!)) * 36)).dp)
                    .background(color = Color(0xFFFFE4E4))
                    .clickable {
                        viewModel.setsched(i)
                    }
                ) {
                    if (viewModel.getsched() == i)
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .border(width = 2.dp, Color.Red)
                                .background(color = Color.Transparent)
                        )
                }
            }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyCard(
) {
    val viewModel = viewModel<ScheduleViewModel>()
    Column(
        verticalArrangement = Arrangement.Top
    ) {
        viewModel.setWeek()
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .height(250.dp),

            ) {
            Column {
                Text(text = "\n")
                Text(
                    text = "${viewModel.dateList[viewModel.scheds[viewModel.currentWorker.value].date!!]}",
                    modifier = Modifier
                        .padding(start = 60.dp)
                )
                Text(
                    text = "${viewModel.scheds[viewModel.currentWorker.value].startTime.toString()} ~ ${viewModel.scheds[viewModel.currentWorker.value].endTime.toString()}",
                    modifier = Modifier
                        .padding(start = 60.dp)
                )
                Text(text = "\n")
                Text(
                    text = "역할 : ${viewModel.scheds[viewModel.currentWorker.value].role.toString()}",
                    modifier = Modifier
                        .padding(start = 60.dp)
                )
                Text(text = "\n")

                Row(
                    modifier = Modifier
                        .background(color = Color.White)
                        .fillMaxWidth()
                        .height(250.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .width(37.dp)
                            .height(40.dp)
                            .background(color = Color.Transparent)
                            .clickable {
                                viewModel.prevWorker()
                            },
                        painter = painterResource(id = R.drawable.prev),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                        colorFilter = ColorFilter.tint(Color(0xFFF17070))
                    )
                    Text(
                        text = "일정 조정 신청하기",
                        fontWeight = FontWeight(1000),
                        modifier = Modifier
                            .border(width = 1.dp, color = Color(0xFFF17070),
                                shape = RoundedCornerShape(size = 10.dp)
                            )
                            .clickable {
                                navigateToAnotherActivity(context, Reschedule::class.java)
                            }
                            .padding(top = 10.dp)
                            .width(264.dp)
                            .height(34.dp)
                            .background(color = Color(0xFFFFFFFF)),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.nanumgothic)),
                            fontWeight = FontWeight(800),
                            color = Color(0xFFF17070),

                            textAlign = TextAlign.Center,
                        )
                    )

                    Image(
                        modifier = Modifier
                            .width(37.dp)
                            .height(40.dp)
                            .background(color = Color.Transparent)
                            .clickable {
                                viewModel.nextWorker()
                            },
                        painter = painterResource(id = R.drawable.prev2),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                        colorFilter = ColorFilter.tint(Color(0xFFF17070))
                    )

                }
            }

        }

    }

}



