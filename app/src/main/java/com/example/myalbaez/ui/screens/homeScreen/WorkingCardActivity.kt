package com.example.myalbaez.ui.screens.homeScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
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
import com.example.myalbaez.ui.theme.gray04
import com.example.myalbaez.ui.theme.pink
import com.example.myalbaez.ui.theme.shadow
import com.example.myalbaez.ui.theme.white
import com.google.gson.Gson
import java.io.InputStreamReader

@OptIn(ExperimentalFoundationApi::class)
class WorkingCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
        modifier = Modifier.background(white),
    ) {
        HorizontalPager(
            state = pagerState, // PagerState
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
        LastCard()
    }
}

/**
 * 각 Card의 UI 구성
 * */
@Composable
fun MyCard(card: homeWorkCard) {
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
            ),
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
                        fontSize = 12.sp,
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
@Composable
fun LastCard() {
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
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Left content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(4.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "User",
                    /*style = MaterialTheme.typography.subtitle1,*/
                    fontWeight = FontWeight.Bold
                )
            }

            // Right content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(4.dp),
                    tint = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Information",
                    /*style = MaterialTheme.typography.subtitle1,*/
                    fontWeight = FontWeight.Bold
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