package com.example.albaez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.albaez.ui.theme.AlbaEzTheme
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.unit.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold


class MainActivity : ComponentActivity() {
    private var homePressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    val items = listOf(
                        BottomNavItem(name = "홈", route = "home", icon = Icons.Default.Home),
                        BottomNavItem(name = "알림", route = "notifications", icon = Icons.Default.Notifications),
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

    override fun onBackPressed() {
        if (homePressed) {
            // If on the home screen and back is pressed, exit the app
            super.onBackPressed()
        } else {
            // If not on the home screen, handle back press as usual (go back in navigation)
            homePressed = false
        }
    }

    private fun onHomeButtonPressed(navController: NavHostController) {
        homePressed = true
        navController.navigate("home") {
            popUpTo(navController.graph.startDestinationRoute!!) {
                saveState = true
            }
            launchSingleTop = true
        }
    }


}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("notifications") {
            NotificationsScreen()
        }
        composable("mypage") {
            MypageScreen()
        }
    }

}

data class BottomNavItem (
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

    AlbaEzTheme {
        BottomNavigation (
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
                        navController.navigate(item.route){
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
                            Color(0xFFF17070)
                        } else {
                            Color.Gray
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

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home screen")
    }
}

@Composable
fun MypageScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Mypage screen")
    }
}

@Composable
fun NotificationsScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Notifications screen")
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationPreview() {
    AlbaEzTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                val items = listOf(
                    BottomNavItem(name = "홈", route = "home", icon = Icons.Default.Home),
                    BottomNavItem(name = "알림", route = "notifications", icon = Icons.Default.Notifications),
                    BottomNavItem(name = "마이페이지", route = "mypage", icon = Icons.Default.Person)
                )
                BottomNavigationBar(
                    items = items,
                    navController = navController,
                    modifier = Modifier,
                    onItemClick = { /* handle item click if needed */ }
                )
            }
        ) { innerPadding ->
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