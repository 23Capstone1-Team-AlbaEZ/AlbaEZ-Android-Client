package com.example.myalbaez

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myalbaez.ui.theme.MyAlbaEzTheme
import scheduleData.GScheduleViewModel

class WorkPlaceScreen : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                val controller = WindowInsetsControllerCompat(window, window.decorView)
                controller.hide(WindowInsetsCompat.Type.systemBars())
                controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            } else {
                window.decorView.systemUiVisibility = android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
            }
            MyAlbaEzTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    ) {


                    //schedule()
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                    ) {
                        GSchedule()
                    }
                }

            }
        }
    }
}

@Composable
fun Announcement() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .width(328.dp)
                .height(23.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Child views.
            Image(
                modifier = Modifier
                    .width(15.dp)
                    .height(23.dp),
                painter = painterResource(id = R.drawable.prev2),
                contentDescription = "image description",
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier
                    .width(53.dp)
                    .height(12.5.dp),
                text = "공지사항",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                    fontWeight = FontWeight(800),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            Text(
                modifier = Modifier
                    .width(250.dp)
                    .height(13.dp),
                text = "이번주 일요일 회식있어요 (필참)",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF696969),
                )
            )
        }
    }
}

@Composable
fun GSchedule(
    viewModel: GScheduleViewModel = viewModel()
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
            .padding(start = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(30.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                modifier = Modifier
                    .width(200.dp)
                    .height(30.dp),
                text = "맥도날드 숭실대",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight(1000),
                color = Color(0xFF5B5B5B),
                letterSpacing = 0.4.sp,
            )
            Announcement()
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
                        .height(((13 + 1) * 36).dp)
                        .padding(start = 0.dp, top = 0.dp, end = 5.dp, bottom = 0.dp),
                    //verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (true) {
                        for (i: Int in 9..22!!) {
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
                        .height(((13 + 1) * 36).dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    if (true) {
                        if (true) {
                            for (i: Int in 9..22!!) {
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
        for (i in viewModel.scheds)
            Box(
                modifier = Modifier
                    //.padding(start = (69+wDate!!*38).dp, top = (101 + (wStartTime!!.minus(wpStartTime!!)) * 36).dp)
                    .padding(
                        start = (69 + i.date!! * 38).dp,
                        top = (101 + (i.startTime!! - 9) * 36 + 23).dp
                    )
            ) {
                Box(modifier = Modifier
                    .width(36.dp)
                    //.height((((wEndTime!!.minus(wStartTime!!)) * 36)).dp)
                    .height((((i.endTime!!.minus(i.startTime!!)) * 36)).dp)
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(size = 2.dp)
                    )
                    .padding(start = 1.dp, top = 1.dp, end = 1.dp, bottom = 1.dp)
                    .clickable {
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = Variables.getColor(),
                                shape = RoundedCornerShape(size = 3.dp)
                            )
                            .align(Alignment.Center)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceEvenly

                        ) {
                            viewModel.countRoles()?.let {
                                Text(
                                    text = it,
                                    fontSize = 6.sp,
                                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                    fontWeight = FontWeight(700),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    color = Color.Black,
                                    textAlign = TextAlign.Center

                                )

                        }
                    }
                }
            }
    }

}
}

object Variables {
    val gray: Color = Color(0xFFE1E1E1)
    val pink: Color = Color(0xFFFFE4E4)
    val purple: Color = Color(0xFFECE0FF)
    val blue: Color = Color(0xFFDBE7FF)
    val orange: Color = Color(0x85FFCE84)
    val green: Color = Color(0xFFD8EDDB)
    val colors: Array<Color> = arrayOf(gray, pink, purple, blue, orange, green)
    var nowColor = 0

    fun getColor(): Color {
        nowColor++
        if (nowColor == 6)
            nowColor = 0
        return colors[nowColor]
    }
}






