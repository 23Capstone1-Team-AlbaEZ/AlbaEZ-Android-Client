package com.example.myalbaez.ui.screens.managerScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myalbaez.MyCard
import com.example.myalbaez.R
import com.example.myalbaez.Schedule
import com.example.myalbaez.navigateToAnotherActivity
import com.example.myalbaez.scheduleData.ScheduleViewModel
import com.example.myalbaez.ui.Reschedule
import com.example.myalbaez.ui.theme.MyAlbaEzTheme
import com.example.myalbaez.ui.theme.gray01
import com.example.myalbaez.ui.theme.pink
import com.example.myalbaez.ui.theme.pure_white
import com.example.myalbaez.ui.theme.white

class MangerAdjustActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            val controller = WindowInsetsControllerCompat(window, window.decorView)
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            MyAlbaEzTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ManagerSchedule()
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                    ) {
                        MyManagerCard()
                    }
                }
            }
        }
    }
}

@Composable
fun ManagerSchedule(viewModel: ScheduleViewModel = viewModel()) {
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
            modifier = Modifier.padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                modifier = Modifier
                    .height(30.dp),
                text = "일정 조정 배정 인원 확정",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight.ExtraBold,
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
                                    for (i: Int in 1..6) Divider(
                                        modifier = Modifier
                                            .width(1.dp)
                                            .fillMaxHeight(),
                                        color = Color.Black
                                    )
                                }
                                Divider(
                                    modifier = Modifier.height(1.dp), color = Color.Black
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
                        for (i: Int in 1..6) Divider(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight(),
                            color = Color.Black
                        )
                    }
                }
            }
        }
        for (i in viewModel.scheds) Box(
            modifier = Modifier
                //.padding(start = (69+wDate!!*38).dp, top = (101 + (wStartTime!!.minus(wpStartTime!!)) * 36).dp)
                .padding(
                    start = (69 + i.date!! * 38).dp,
                    //top = (101+(i.endTime!!.minus(i.startTime!!)) * 36).dp
                    top = (101 + (i.startTime!! - 9) * 36).dp
                )
        ) {
            Box(modifier = Modifier
                .width(36.dp)
                //.height((((wEndTime!!.minus(wStartTime!!)) * 36)).dp)
                .height((((i.endTime!!.minus(i.startTime!!)) * 36)).dp)
                .background(color = Color(0xFFFFE4E4))
                .clickable {
                    viewModel.setsched(i)
                }) {
                if (viewModel.getsched() == i) Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .border(width = 2.dp, Color.Red)
                        .background(color = Color.Transparent)
                )
            }
        }

    }
}

@Composable
fun MyManagerCard(
) {
    val viewModel = viewModel<ScheduleViewModel>()
    Column(
        verticalArrangement = Arrangement.Top
    ) {
        viewModel.setWeek()
        val context = LocalContext.current
        val scrollState= rememberScrollState()

        val imageResourceIds1: List<Int> = listOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c
        )
        val imageResourceIds2: List<Int> = listOf(
            R.drawable.d,
            R.drawable.e,
            R.drawable.f
        )
        val members1 : Array<String> = arrayOf("김희환", "김태현", "송승우")
        val members2 : Array<String> = arrayOf("구교민", "옥채연", "손흥민")
        val imagePainter1: List<Painter> = imageResourceIds1.map { painterResource(id = it) }
        val imagePainter2: List<Painter> = imageResourceIds2.map { painterResource(id = it) }

        Column(
            modifier=Modifier.verticalScroll(scrollState)
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
        ){
            Box(
                modifier = Modifier
                    .background(color = pure_white)
                    .size(height = 350.dp,width=500.dp)
                    .border(1.dp, gray01,RoundedCornerShape(5.dp))
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(5.dp)),
            ) {
                Column(
                    modifier = Modifier
                        .offset(x=60.dp)
                        .verticalScroll(scrollState)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = "${viewModel.dateList[viewModel.scheds[viewModel.currentWorker.value].date!!]}" +
                                "  ${viewModel.scheds[viewModel.currentWorker.value].workplace.toString()}",
                        fontSize = 18.sp,
                        color = pink
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "일정조정 요청자 : 김민재",
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "시간 : ${viewModel.scheds[viewModel.currentWorker.value].startTime.toString()}시 ~ ${viewModel.scheds[viewModel.currentWorker.value].endTime.toString()}시",
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "역할 : ${viewModel.scheds[viewModel.currentWorker.value].role.toString()}",
                        modifier = Modifier.padding(start = 10.dp),
                        fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column {
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "업장 내 근무자 수락 명단",
                            color = pink,
                            fontSize = 16.sp,
                        )
                        val member1Condition = SelectCondition(false, true, true)
                        coWorkerCardRow(imagePainter1, members1, member1Condition)

                        Spacer(Modifier.height(10.dp))
                        Text(
                            fontWeight = FontWeight.Bold,
                            text = "긱잡 공고 지원자 명단",
                            color = pink,
                            fontSize = 16.sp,
                        )
                        val member2Condition = SelectCondition(true, true, true)
                        coWorkerCardRow(imagePainter2, members2, member2Condition)
                    }

                }
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .align(Alignment.BottomCenter),
                ) {
                    Row(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .absoluteOffset(5.dp),
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
                        Text(text = "인원 배정 확정하기",
                            fontWeight = FontWeight(1000),
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFF17070),
                                    shape = RoundedCornerShape(size = 10.dp)
                                )
                                .clickable {
                                    /*navigateToAnotherActivity(context, Reschedule::class.java)*/
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
}

class SelectCondition (
    val condition1: Boolean,
    val condition2: Boolean,
    val condition3: Boolean
)

@Composable
private fun coWorkerCardRow(image: List<Painter>, memberId: Array<String>, conditions:SelectCondition) {
    Row(
        modifier = Modifier
            .background(Color.Transparent)
            .offset(x=10.dp)
    ){
        coWorkerCardCol(image[0], memberId[0], conditions.condition1)
        Spacer(modifier = Modifier.width(16.dp)) // Col 사이의 간격을 설정합니다.
        coWorkerCardCol(image[1], memberId[1], conditions.condition2)
        Spacer(modifier = Modifier.width(16.dp))
        coWorkerCardCol(image[2], memberId[2], conditions.condition3)
    }
}

@Composable
private fun coWorkerCardCol(image: Painter, memberId: String, condition:Boolean){
    val borderModifier = if (condition) {
        Modifier.border(width = 2.dp, color = Color.Transparent, shape = RoundedCornerShape(size = 32.dp))

    } else {
        Modifier.border(width = 2.dp, color = pink, shape = RoundedCornerShape(size = 36.dp))
    }
    Column(
        modifier = Modifier
            .padding(2.dp)
            .size(52.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .then(borderModifier),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(0.dp))
        Text(
            text = memberId,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun MyManagerCardPreview() {
    MyAlbaEzTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            ManagerSchedule()
            Column(
                verticalArrangement = Arrangement.Bottom,
            ) {
                MyManagerCard()
            }
        }
    }
}