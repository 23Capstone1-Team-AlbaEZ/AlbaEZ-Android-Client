package com.example.myalbaez.ui.screens.notification

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.myalbaez.ui.screens.notification.dataClass.notiDataClass
import com.example.myalbaez.ui.theme.gigJobPostTypo
import com.example.myalbaez.ui.theme.gray05
import com.example.myalbaez.ui.theme.notiAlarmTypo
import com.example.myalbaez.ui.theme.pure_white
import com.example.myalbaez.ui.theme.purple
import com.example.myalbaez.ui.theme.white
import com.google.gson.Gson
import java.io.InputStreamReader

class NotiActivity : ComponentActivity() {
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
            val jsonData = assets.open("notificationDataWorker.json")
                .use { InputStreamReader(it).readText() }
            val gson = Gson()
            val alarmList: List<notiDataClass> =
                gson.fromJson(jsonData, Array<notiDataClass>::class.java).toList()

            NotificationScreen(alarmList = alarmList)
        }
    }
}



@Composable
fun NotificationScreen(alarmList: List<notiDataClass>) {
    Column() {
        Column(
            modifier = Modifier.padding(35.dp)
        ) {
            Text(
                text = "새로운 알람 목록",
                style = gigJobPostTypo.displayLarge,
                fontSize = 20.sp,
                color = gray05,
                letterSpacing = 0.4.sp,
            )
            Spacer(modifier = Modifier.height(31.dp))
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = purple)
                    ) {
                        append(alarmList.size.toString())
                    }
                    append("건의 새로운 알람이 존재합니다. 확인해보세요")
                }
            )
        }
        NofiSlider(alarmList = alarmList)
    }
}

@Composable
fun NofiSlider(alarmList: List<notiDataClass>) {
    var scrollState by remember { mutableFloatStateOf(0f) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, _, _ ->
                    scrollState += pan.x
                }
            }
            .background(white),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items(alarmList.size) {
            // Composable function for each card
            NofiCard(alarm = alarmList[it])
        }
    }
}

@Composable
fun NofiCard(alarm: notiDataClass) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = pure_white,
        ),
        modifier = Modifier.size(width = 340.dp, height = 133.dp),
        /*onClick = {
            클릭 시 alarmID를 이용해 해당 page로 이동
        }*/
    ) {
        // notificationDataWorker : "새로운 일정 조정 신청이 있습니다.\n11월 17일 13시\n신청자 OOO"
        // notificationDataManger : "11월 17일 13시 일정 조정에 OOO님이 수락하셨어요. 근무자를 배정할 지 확인해주세요"

        var nofiComment: String =
            when (alarm.content) {
                "새로운 일정 조정 신청이 있습니다." -> {
                    alarm.content+"\n"+alarm.adjustDate+" "+alarm.startTime+"\n신청자 "+alarm.person
                }
                "근무자를 배정할 지 확인해주세요." -> {
                    alarm.adjustDate+" "+alarm.startTime+"일정 조정에 "+alarm.person+"님이 수락하셨어요. \n"+alarm.content
                }
                else -> {alarm.content}
            }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = nofiComment,
                style = notiAlarmTypo.displayMedium,
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}