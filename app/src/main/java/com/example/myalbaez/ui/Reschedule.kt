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
import androidx.compose.foundation.layout.sizeIn
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

//사업장 멤버 선택 화면(코드가 좀 깁니다 양해바랍니다)
@Composable
private fun coWorkerCards(){
    // ResourcePainter를 사용하여 Painter 생성
    val imageResourceIds1: List<Int> = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c
    )
    val imageResourceIds2: List<Int> = listOf(
        R.drawable.d,
        R.drawable.e,
        R.drawable.f
    )
    val imageResourceIds3: List<Int> = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c
    )
    val imageResourceIds4: List<Int> = listOf(
        R.drawable.d,
        R.drawable.e,
        R.drawable.f
    )
    val imagePainter1: List<Painter> = imageResourceIds1.map { painterResource(id = it) }
    val imagePainter2: List<Painter> = imageResourceIds2.map { painterResource(id = it) }
    val imagePainter3: List<Painter> = imageResourceIds3.map { painterResource(id = it) }
    val imagePainter4: List<Painter> = imageResourceIds4.map { painterResource(id = it) }
    val members1 : Array<String> = arrayOf("김희환", "김태현", "송승우")
    val members2 : Array<String> = arrayOf("구교민", "옥채연", "손흥민")
    val members3 : Array<String> = arrayOf("구자철", "안정환", "이승우")
    val members4 : Array<String> = arrayOf("호날두", "웨인 루니", "비카리오")
    val condition1: Boolean = true
    val condition2: Boolean = false
    Column(
    ){
        coWorkerCardRow(imagePainter1, members1, condition1)
        Spacer(modifier = Modifier.height(32.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter2, members2, condition2)
        Spacer(modifier = Modifier.height(32.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter3, members3, condition1)
        Spacer(modifier = Modifier.height(32.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter4, members4, condition1)
    }
}

//사업장 멤버 행 요소
@Composable
private fun coWorkerCardRow(image: List<Painter>, memberId: Array<String>, condition: Boolean) {
    Row(
        modifier = Modifier
            .background(Color.Transparent)
    ){
        coWorkerCardCol(image[0], memberId[0], condition)
        Spacer(modifier = Modifier.width(16.dp)) // Col 사이의 간격을 설정합니다.
        coWorkerCardCol(image[1], memberId[1], condition)
        Spacer(modifier = Modifier.width(16.dp))
        coWorkerCardCol(image[2], memberId[2], condition)
    }
}

//사업장 멤버 열 요소
@Composable
private fun coWorkerCardCol(image: Painter, memberId: String, condition: Boolean){
    val borderModifier = if (condition) {
        Modifier.border(width = 2.dp, color = Color.Transparent, shape = RoundedCornerShape(size = 64.dp))
    } else {
        Modifier.border(width = 2.dp, color = Color(0xFFF17070), shape = RoundedCornerShape(size = 64.dp))
    }
    Column(
        modifier = Modifier
            .padding(4.dp)
            .size(84.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .then(borderModifier),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(0.dp))
        Text(
            text = memberId,
            )
    }
}

//맨 밑 버튼
@Composable
private fun Btns(
){
    // 첫 번째 버튼 : 취소 버튼
    Box(
        modifier = Modifier
            .sizeIn(maxWidth = 130.dp, maxHeight = 53.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(130.dp)
                .clickable {
                    // 취소 버튼이 클릭되었을 때 수행할 작업
                },
            painter = painterResource(id = R.drawable.cancel_btn),
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .offset ( x =41.dp, y = 19.dp),
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
            .sizeIn(maxWidth = 130.dp, maxHeight = 53.dp)
            .clickable {
                // 신청 버튼이 클릭되었을 때 수행할 작업
            }
    ) {
        Image(
            modifier = Modifier
                .padding(4.dp)
                .size(130.dp)
                .clickable {
                    // 취소 버튼이 클릭되었을 때 수행할 작업
                },
            painter = painterResource(id = R.drawable.apply_btn),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .offset ( x =41.dp, y = 19.dp),
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
                .align(Alignment.BottomCenter)
                .offset(y = (-40).dp),
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