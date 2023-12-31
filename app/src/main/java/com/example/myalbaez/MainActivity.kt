@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myalbaez

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myalbaez.ui.BottomNavigationBar
import com.example.myalbaez.ui.items
import com.example.myalbaez.ui.screens.homeScreen.HomeScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.myalbaez.ui.screens.notification.NotiMangerActivity
import com.example.myalbaez.ui.screens.notification.NotificationDataLoader
import com.example.myalbaez.ui.screens.notification.NotificationMangerScreen
import com.example.myalbaez.ui.screens.notification.NotificationScreen
import com.example.myalbaez.ui.screens.notification.dataClass.notiDataClass

/*Colors Import*/

class MainActivity : ComponentActivity() {
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
            AlbaezApp(modifier = Modifier)
        }
    }
}
private fun onHomeButtonPressed(navController: NavHostController) {
    var homePressed = true
    navController.navigate("home") {
        popUpTo(navController.graph.startDestinationRoute!!) {
            saveState = true
        }
        launchSingleTop = true
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbaezApp(modifier:Modifier=Modifier){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(items = items,navController = navController,modifier = Modifier,onItemClick = { item -> if (item.route == "home") {
                        onHomeButtonPressed(navController)
                    }
                }
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
@Composable
fun Navigation(navController: NavHostController) {
    val context=LocalContext.current
    val notificationDataLoader = NotificationDataLoader(context)
    val alarmList: List<notiDataClass> = notificationDataLoader.loadNotificationData()
    val malarmList: List<notiDataClass> = notificationDataLoader.loadManagerNotificationData()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("notifications") {
            val manager = true
            if(manager)
                NotificationMangerScreen(malarmList)
            else
                NotificationScreen(alarmList)
        }
        composable("mypage") {
            //MypageScreen()
        }
    }
}

fun navigateToAnotherActivity(context: Context, destinationActivity: Class<*>) {
    val intent = Intent(context, destinationActivity)
    context.startActivity(intent)
}
