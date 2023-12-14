package com.example.myalbaez.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myalbaez.ui.theme.MyAlbaEzTheme
import com.example.myalbaez.ui.theme.gray03
import com.example.myalbaez.ui.theme.pink
data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

val items=listOf(
    BottomNavItem(name = "홈", route = "home", icon = Icons.Default.Home),
    BottomNavItem(name = "알림",route = "notifications",icon = Icons.Default.Notifications),
    BottomNavItem(name = "마이페이지", route = "mypage", icon = Icons.Default.Person)
)

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
                    icon = {
                        val iconColor = if (selected) {pink} else {gray03}
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
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