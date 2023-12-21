package com.example.myalbaez.ui.screens.homeScreen

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.myalbaez.MyScheduler
import com.example.myalbaez.R
import com.example.myalbaez.WorkPlaceScreen
import com.example.myalbaez.navigateToAnotherActivity
import com.example.myalbaez.ui.screens.gigjobposts.GigjobPostsActivity
import com.example.myalbaez.ui.screens.gigjobposts.dataClass.gigjobPost
import com.example.myalbaez.ui.screens.gigjobposts.gigjobPostCard
import com.example.myalbaez.ui.screens.homeScreen.dataClass.homeWorkCard
import com.example.myalbaez.ui.theme.gray01
import com.example.myalbaez.ui.theme.pink
import com.example.myalbaez.ui.theme.pure_white
import com.example.myalbaez.ui.theme.white
import com.google.gson.Gson
import java.io.InputStreamReader

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                val controller = WindowInsetsControllerCompat(window, window.decorView)
                controller.hide(WindowInsetsCompat.Type.systemBars())
                controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            } else {
                window.decorView.systemUiVisibility = android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
            }
            HomeScreen()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {

    val gson = Gson()
    // Access the assets in the preview using LocalContext
    val homeCardJsonData = LocalContext.current.assets.open("homePrivateScheduleData.json")
        .use { InputStreamReader(it).readText() }
    val homeCardList: List<homeWorkCard> =
        gson.fromJson(homeCardJsonData, Array<homeWorkCard>::class.java).toList()
    val pagerState = rememberPagerState {
        homeCardList.size
    }
    val context = LocalContext.current

    val gigJobJsonData = LocalContext.current.assets.open("gigjobPostsListData.json")
        .use { InputStreamReader(it).readText() }
    val jobPostCardList: List<gigjobPost> =
        gson.fromJson(gigJobJsonData, Array<gigjobPost>::class.java).toList()

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(33.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "AlbaEZ",
            style = TextStyle(
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.allertastencil)),
                fontWeight = FontWeight(400),
                color = pink,
                textAlign = TextAlign.Center,
                letterSpacing = 0.72.sp,
            )
        )
        Spacer(modifier = Modifier.height(29.dp))

        // Home working alba Pager and Indicator
        Column(
            modifier = Modifier.background(color = white),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            WorkingAlbaCardPager(cardList = homeCardList, pagerState)
        }
        // Gigjob 추천 공고글
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            //안내문구 + 화살표
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "AI가 추천하는 긱잡 공고글을 확인해보세요!",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(400),
                        color = gray01,
                    )
                )
                Image(
                    modifier = Modifier
                        .padding(0.dp)
                        .width(30.dp)
                        .height(13.dp)
                        .clickable {
                            navigateToAnotherActivity(context, GigjobPostsActivity::class.java)
                        },
                    painter = painterResource(id = R.drawable.ic_action_name),
                    contentDescription = "image description",
                    contentScale = ContentScale.None,
                )
            }
            Spacer(modifier = Modifier.height(23.dp))

            // Gigjob Post Card
            Column {
                gigjobPostCard(card = jobPostCardList[0])
                Spacer(modifier = Modifier.height(5.dp))
                gigjobPostCard(card = jobPostCardList[1])
            }
            Spacer(modifier = Modifier.height(23.dp))

            // 버튼 4개
            Column(
                modifier = Modifier.width(342.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                Row(
                    modifier = Modifier.width(342.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = pure_white,
                        ),
                        modifier = Modifier
                            .size(
                                width = 155.dp,
                                height = 67.dp
                            )
                            .clickable {
                                navigateToAnotherActivity(context, MyScheduler::class.java)
                            }
                    ) {
                        Row(
                            modifier = Modifier
                                .width(155.dp)
                                .height(67.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp),
                                painter = painterResource(id = R.drawable.scheduler),
                                contentDescription = "image description",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(pink)

                            )
                            Text(
                                text = "알바 캘린더 보기",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                    fontWeight = FontWeight(700),
                                    color = gray01,
                                )
                            )
                        }
                    }
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = pure_white,
                        ),
                        modifier = Modifier
                            .size(
                                width = 155.dp,
                                height = 67.dp
                            )
                            .clickable {
                                navigateToAnotherActivity(context, GigjobPostsActivity::class.java)
                            },
                    ) {
                        Row(
                            modifier = Modifier
                                .width(155.dp)
                                .height(67.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp),
                                painter = painterResource(id = R.drawable.finder),
                                contentDescription = "image description",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(pink)
                            )
                            Text(
                                text = "  긱잡 구하기  ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                    fontWeight = FontWeight(700),
                                    color = gray01,
                                )
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.width(342.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = pure_white,
                        ),
                        modifier = Modifier
                            .size(
                                width = 155.dp,
                                height = 67.dp
                            )
                        /*.clickable {
                            navigateToAnotherActivity(context, WorkPlaceScreen::class.java)
                        }*/
                    ) {
                        Row(
                            modifier = Modifier
                                .width(155.dp)
                                .height(67.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp),
                                painter = painterResource(id = R.drawable.cash),
                                contentDescription = "image description",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(pink)
                            )
                            Text(
                                text = "  급여 관리   ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                    fontWeight = FontWeight(700),
                                    color = gray01,
                                )
                            )
                        }
                    }
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = pure_white,
                        ),
                        modifier = Modifier
                            .size(
                                width = 155.dp,
                                height = 67.dp
                            )
                        /*.clickable {
                            navigateToAnotherActivity(context, WorkPlaceScreen::class.java)
                        }*/
                    ) {
                        Row(
                            modifier = Modifier
                                .width(155.dp)
                                .height(67.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp),
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = "image description",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(pink)
                            )
                            Text(
                                text = "  이력서 관리  ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                    fontWeight = FontWeight(700),
                                    color = gray01,
                                )
                            )
                        }
                    }
                }
            }
            Column(
                modifier=Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                LastCard()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(23.dp))
    }
}