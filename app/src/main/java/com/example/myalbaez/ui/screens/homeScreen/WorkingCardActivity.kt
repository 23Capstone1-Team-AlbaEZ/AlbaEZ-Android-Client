package com.example.myalbaez.ui.screens.homeScreen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.myalbaez.WorkPlaceScreen
import com.example.myalbaez.navigateToAnotherActivity
import com.example.myalbaez.ui.screens.homeScreen.dataClass.homeWorkCard
import com.example.myalbaez.ui.theme.gray04
import com.example.myalbaez.ui.theme.pink
import com.example.myalbaez.ui.theme.shadow
import com.example.myalbaez.ui.theme.textFieldColor
import com.example.myalbaez.ui.theme.white
import com.google.gson.Gson
import java.io.InputStreamReader

@OptIn(ExperimentalFoundationApi::class)
class WorkingCardActivity : ComponentActivity() {
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
            val jsonData = assets.open("homePrivateScheduleData.json")
                .use { InputStreamReader(it).readText() }

            val gson = Gson()
            val cardList: List<homeWorkCard> =
                gson.fromJson(jsonData, Array<homeWorkCard>::class.java).toList()

            val pagerState = rememberPagerState {
                cardList.size
            }

            WorkingAlbaCardPager(cardList = cardList, pagerState)
        }
    }
}

/**
 * HorizontalPager를 이용한 알바 사업장 목록 별 일정 Paging
 * */
@OptIn(ExperimentalFoundationApi::class)
@Suppress("unused*")

@Composable
fun WorkingAlbaCardPager(cardList: List<homeWorkCard>, pagerState: PagerState) {

    Column(
        modifier = Modifier
            .background(white)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        HorizontalPager(
            state = pagerState, // PagerState
            contentPadding = PaddingValues(horizontal=24.dp)
        ) { index ->
            // 페이지 content
            MyCard(cardList[index])
        }
        Spacer(modifier = Modifier.height(19.dp))
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color: Color
                val isIteration: Modifier
                if (pagerState.currentPage == iteration) {
                    color = pink
                    isIteration = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(color)
                        .size(width = 15.dp, height = 8.dp)
                } else {
                    color = gray04
                    isIteration = Modifier
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                }
                Box(modifier = isIteration)
                Spacer(modifier = Modifier.width(2.dp))
            }
        }
        /*LastCard()*/
    }
}

/**
 * 각 Card의 UI 구성
 * */
@Composable
fun MyCard(card: homeWorkCard) {
    val context = LocalContext.current
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = pink,
        ),
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = shadow,
                ambientColor = shadow
            )
            .size(
                width = 340.dp,
                height = 126.dp
            )
            .clickable {
                navigateToAnotherActivity(context, WorkPlaceScreen::class.java)
            },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopStart,
            ) {
                Text(
                    text = card.workplaceName,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            /*val numberOfSubData = card.subdataList.size*/
            Column(
                modifier=Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                for (workData in card.scheduleList) {
                    val day = workData.day
                    val startTime = workData.startTime
                    val endTime = workData.endTime
                    val workTimeZoneText = "$day | $startTime ~ $endTime"
                    Text(
                        text = workTimeZoneText,
                        color = Color.White,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center,
                    )
                    /*Spacer(modifier = Modifier.height(1.dp))*/
                }
            }
        }
    }
}

/**
 * 마지막 카드 (사업장 코드 입력, 사업장 생성)
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LastCard() {
    val (workplaceCodeInput,setInput)=remember{ mutableStateOf("") }

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = pink,
        ),
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = shadow,
                ambientColor = shadow
            )
            .size(width = 340.dp, height = 126.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left content
            Column(
                modifier = Modifier
                    .padding(end = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row{
                    TextField(
                        value = workplaceCodeInput,
                        onValueChange = setInput,
                        modifier= Modifier
                            .width(110.dp)
                            .height(40.dp)
                            .padding(4.dp),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Icon(
                        imageVector = Icons.Default.Send,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(size = 3.dp))
                            .padding(4.dp)
                            .background(textFieldColor)
                        ,
                        tint = pink
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "사업장 코드 입력",
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }

            // Right content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(4.dp),
                    tint = white
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "사업장 생성",
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
        }
    }
}

/**
 * Preview
 * */
@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreenPreview() {

    // Access the assets in the preview using LocalContext
    val jsonData = LocalContext.current.assets.open("homePrivateScheduleData.json")
        .use { InputStreamReader(it).readText() }

    val gson = Gson()
    val cardList: List<homeWorkCard> =
        gson.fromJson(jsonData, Array<homeWorkCard>::class.java).toList()

    val pagerState = rememberPagerState {
        cardList.size
    }
    WorkingAlbaCardPager(cardList = cardList, pagerState)
}