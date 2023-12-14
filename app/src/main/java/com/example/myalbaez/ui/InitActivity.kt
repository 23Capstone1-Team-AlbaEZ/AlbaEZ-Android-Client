package com.example.myalbaez.ui

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.myalbaez.MainActivity
import com.example.myalbaez.R
import com.example.myalbaez.ui.theme.MyAlbaEzTheme
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class InitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KakaoSdk.init(this, "1c0cbde69cd30713300b94d1f4420b83")
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
                    color = Color.White
                ) {
                    InitScreen()
                }
            }
        }
    }
}

@Composable
fun InitScreen() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF17070))
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.alba_ez_icon),
            contentDescription = "login window",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 50.dp)
                .padding(bottom = 428.dp)
        )

        KakaoLoginButton(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 150.dp)
                .padding(top = 16.dp)
        ) {
            handleKakaoLogin(context)
        }
    }
}

@Composable
fun KakaoLoginButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .wrapContentSize()
            .scale(1.3f)
            .background(Color(0xFFF17070))
    ) {
        Image(
            painter = painterResource(id = R.drawable.kakao_login_btn_large),
            contentDescription = "kakao login button"
        )
    }
}

fun handleKakaoLogin(context: android.content.Context) {
    // 카카오 로그인 처리
    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            // 로그인 실패 처리
            Log.e("LOGIN", "카카오톡으로 로그인 실패", error)
        } else if (token != null) {
            // 로그인 성공 처리
            Log.i("LOGIN", "카카오톡으로 로그인 성공 ${token.accessToken}")
        }
    }

    // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) {
                // 카카오톡으로 로그인 실패 처리
                Log.e("LOGIN", "카카오톡으로 로그인 실패", error)
                if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우
                    // 의도적인 로그인 취소로 보고 처리
                    return@loginWithKakaoTalk
                } else {
                    // 그 외의 경우, 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                }
            } else if (token != null) {
                // 카카오톡으로 로그인 성공 처리
                Log.i("LOGIN", "카카오톡으로 로그인 성공 ${token.accessToken}")
                // 성공한 경우에는 기존 MainActivity로 이동하도록 설정
                if (context is Activity) {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    (context as Activity).finish()
                }
            }
        }
    } else {
        // 카카오톡이 설치되어 있지 않으면 카카오계정으로 로그인 시도
        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }
}

@Preview(showBackground = true)
@Composable
fun InitScreenPreview() {
    MyAlbaEzTheme {
        InitScreen()
    }
}
