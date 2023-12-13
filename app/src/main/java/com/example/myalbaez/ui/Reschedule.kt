package com.example.myalbaez.ui

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myalbaez.InitScreen
import com.example.myalbaez.ui.theme.MyAlbaEzTheme
import com.example.myalbaez.R

class Reschedule : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    ApplyActivity()
                }
        }
    }
}

//사업장 멤버 선택 화면
@Composable
private fun coWorkerCards(){
    // ResourcePainter를 사용하여 Painter 생성
    val imagePainter: Painter = painterResource(id = R.drawable.alba_ez_icon)
    Column(
    ){
        coWorkerCardRow(imagePainter, "memberId1")
        Spacer(modifier = Modifier.height(32.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter, "memberId2")
        Spacer(modifier = Modifier.height(32.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter, "memberId3")
        Spacer(modifier = Modifier.height(32.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter, "memberId4")
    }
}

//사업장 멤버 행 요소
@Composable
private fun coWorkerCardRow(image: Painter, memberId: String) {
    Row(
        modifier = Modifier
            .background(Color.Transparent)
    ){
        coWorkerCardCol(image, memberId)
        Spacer(modifier = Modifier.width(16.dp)) // Col 사이의 간격을 설정합니다.
        coWorkerCardCol(image, memberId)
        Spacer(modifier = Modifier.width(16.dp))
        coWorkerCardCol(image, memberId)
    }
}

//사업장 멤버 열 요소
@Composable
private fun coWorkerCardCol(image: Painter, memberId: String){
    var condition: Boolean = true
    val borderModifier = if (condition) {
        Modifier.border(width = 4.dp, color = Color.Transparent, shape = RoundedCornerShape(size = 84.dp))
    } else {
        Modifier.border(width = 4.dp, color = Color(0xFFF17070), shape = RoundedCornerShape(size = 84.dp))
    }
    Column(
        modifier = Modifier
            .then(borderModifier)
            .padding(4.dp)
            .width(84.dp)
            .height(84.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = image,
            modifier = Modifier
                .size(84.dp)
                .clip(CircleShape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

//맨 밑 버튼
@Composable
private fun Btns(){
    // 첫 번째 버튼 : 취소 버튼
    Box(
        modifier = Modifier
            .size(130.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .size(130.dp)
                .clickable {
                    // 취소 버튼이 클릭되었을 때 수행할 작업
                },
            painter = painterResource(id = R.drawable.cancel_btn),
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .offset ( x =41.dp, y = 57.dp),
            text = "취소",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight(800),
                color = Color(0xFFF17070),
                textAlign = TextAlign.Center,
                letterSpacing = 11.2.sp,
            )
        )
    }
    // 간격 추가
    Spacer(modifier = Modifier.width(16.dp))
    // 두 번째 버튼 : 신청 버튼
    Box(
        modifier = Modifier
            .size(130.dp)
            .clickable {
                // 신청 버튼이 클릭되었을 때 수행할 작업
            }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .size(130.dp)
                .clickable {
                    // 취소 버튼이 클릭되었을 때 수행할 작업
                },
            painter = painterResource(id = R.drawable.apply_btn),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .offset ( x =41.dp, y = 57.dp),
            text = "신청",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight(800),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 11.2.sp,
            )
        )
    }
}

//전체 화면 구성
@Composable
private fun ApplyActivity(){
    Box(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .background(Color(0xFFFFFAFA))
    ){
        Text(
            modifier = Modifier
                .offset(x = 35.dp, y = 41.dp),
            text = "일정 조정 신청",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight(700),
                color = Color(0xFF5B5B5B),
                letterSpacing = 0.4.sp,
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 88.dp, bottom = 0.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 30.dp))
    ){
        Text(
            modifier = Modifier
                .offset(x = 48.dp, y = 56.dp),
            text = "2023년 10월 30일 월요일\n09:00 ~ 16:00",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )
        Text(
            modifier = Modifier
                .offset(x = 48.dp, y = 119.dp),
            text = "역할 : 주방",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nanumgothic)),
                fontWeight = FontWeight(700),
                color = Color(0xFF696969),

                )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 170.dp),
            horizontalArrangement = Arrangement.Center
        ){
            coWorkerCards()
        }
        Spacer(modifier = Modifier.height(16.dp))
        // 추가된 버튼
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Btns()
        }
    }
}

@Preview
@Composable
private fun AppPreview(){
    ApplyActivity()
}