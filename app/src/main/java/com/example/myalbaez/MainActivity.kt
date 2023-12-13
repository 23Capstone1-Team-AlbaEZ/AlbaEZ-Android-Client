package com.example.myalbaez

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myalbaez.ui.screens.gigjobposts.GigjobPostsActivity
import com.example.myalbaez.ui.screens.gigjobposts.dataClass.gigjobPost
import com.example.myalbaez.ui.screens.gigjobposts.gigjobPostCard
import com.example.myalbaez.ui.screens.homeScreen.WorkingAlbaCardPager
import com.example.myalbaez.ui.screens.homeScreen.dataClass.homeWorkCard
import com.example.myalbaez.ui.theme.MyAlbaEzTheme
import com.example.myalbaez.ui.theme.gray01

/*Colors Import*/
import com.example.myalbaez.ui.theme.gray03
import com.example.myalbaez.ui.theme.pink
import com.example.myalbaez.ui.theme.pure_white
import com.example.myalbaez.ui.theme.white
import com.google.gson.Gson
import org.intellij.lang.annotations.PrintFormat
import java.io.InputStreamReader

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    private var homePressed = false
    private lateinit var navController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    val items = listOf(
                        BottomNavItem(name = "홈", route = "home", icon = Icons.Default.Home),
                        BottomNavItem(
                            name = "알림",
                            route = "notifications",
                            icon = Icons.Default.Notifications
                        ),
                        BottomNavItem(name = "마이페이지", route = "mypage", icon = Icons.Default.Person)
                    )
                    BottomNavigationBar(
                        items = items,
                        navController = navController,
                        modifier = Modifier,
                        onItemClick = { item ->
                            // handle item click
                            if (item.route == "home") {
                                onHomeButtonPressed(navController)
                            }
                        }
                    )
                }
            ) { innerPadding ->
                // Add contentPadding to the NavHost
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }

    private fun onHomeButtonPressed(navController: NavHostController) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            homePressed = true
        }
        navController.navigate("home") {
            popUpTo(navController.graph.startDestinationRoute!!) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

fun navigateToAnotherActivity(context: Context, destinationActivity: Class<*>) {
    val intent = Intent(context, destinationActivity)
    context.startActivity(intent)
}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                HomeScreen()
            }
        }
        composable("notifications") {
            //NotificationsScreen()
        }
        composable("mypage") {
            //MypageScreen()
        }
    }

}

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    MyAlbaEzTheme {
        BottomNavigation(
            modifier = modifier,
            backgroundColor = Color.White,
            elevation = 5.dp
        ) {
            // items 배열에 담긴 모든 항목을 추가합니다.
            items.forEach { item ->
                // 뷰의 활동 상태를 백스택에 담아 저장합니다.
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = {
                        onItemClick(item)
                        // 클릭한 아이템에 해당하는 라우트로 네비게이션 수행
                        navController.navigate(item.route) {
                            // Pop up to the start destination when reselecting the same item
                            popUpTo(navController.graph.startDestinationRoute!!) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when reselecting the same item
                            launchSingleTop = true
                        }
                    },
//                    selectedContentColor = MaterialTheme.colorScheme.primary,
//                    unselectedContentColor = Color.Gray,
                    icon = {
                        val iconColor = if (selected) {
                            pink
                        } else {
                            /*Color.Gray*/
                            gray03
                        }
                        Column(horizontalAlignment = CenterHorizontally) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                tint = iconColor // 아이콘 색상 설정
                            )
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                            )
                        }
                    }
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreen() {

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
            style = androidx.compose.ui.text.TextStyle(
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
            modifier = Modifier
                .background(color = white)
            /*.padding(top = 20.dp, start = 35.dp)*/,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            WorkingAlbaCardPager(cardList = homeCardList, pagerState)
            Spacer(modifier = Modifier.height(16.dp))
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
                    style = androidx.compose.ui.text.TextStyle(
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
                                style = androidx.compose.ui.text.TextStyle(
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
                                style = androidx.compose.ui.text.TextStyle(
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
                                style = androidx.compose.ui.text.TextStyle(
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
                                style = androidx.compose.ui.text.TextStyle(
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
        }
        Spacer(modifier = Modifier.height(23.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    // Assuming you have a navController to pass to the BottomNavigationBar
    BottomNavigationBar(
        items = listOf(
            BottomNavItem(name = "홈", route = "home", icon = Icons.Default.Home),
            BottomNavItem(
                name = "알림",
                route = "notifications",
                icon = Icons.Default.Notifications
            ),
            BottomNavItem(name = "마이페이지", route = "mypage", icon = Icons.Default.Person)
        ),
        navController = rememberNavController(),
        onItemClick = {}
    )
}