package com.example.myalbaez.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myalbaez.R
import com.example.myalbaez.WorkPlaceScreen
import com.example.myalbaez.navigateToAnotherActivity
import com.example.myalbaez.ui.screens.gigjobposts.GigjobPostsActivity
import com.example.myalbaez.ui.theme.gray01
import com.example.myalbaez.ui.theme.pink
import com.example.myalbaez.ui.theme.pure_white

class RecruitInfo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainInfo()
            /*{
                "gigjobPostID": 1,
                "scheduleAdjustID": 1,
                "workplaceName": "맥도날드 숭실대점",
                "address": "서울특별시 동작구 상도동 505-5",
                "content": "서빙알바 급구",
                "payForm": "시급",
                "pay": "9,000원",
                "day": "MON",
                "startTime": "12:00",
                "endTime": "15:00",
                "postDate": "2023-11-29",
                "expirationDate": "2023-12-31"
            }*/
        }
    }
}

@Composable
private fun mainInfo(){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ){
        Spacer(modifier = Modifier.height(40.dp))
        Column(

        ){
            Text(
                modifier = Modifier
                    .offset(x = 15.dp),
                text = "계약직 채용 | 주방 알바 급구",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                    fontWeight = FontWeight.ExtraBold,
                    color = gray01,
                )
            )
            Spacer(modifier = Modifier.height(23.dp))
            Row(){
                Image(
                    painter = painterResource(id =R.drawable.a),
                    modifier = Modifier
                        .offset(x = 22.dp)
                        .size(32.dp)
                        .clip(CircleShape),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(

                    modifier = Modifier
                        .offset(x = 10.dp)
                        .align(Alignment.CenterVertically),
                    text = "맥도날드 숭실대점",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(300),
                        color = gray01,
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(23.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
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
//                            .clickable {
//                                navigateToAnotherActivity(context, WorkPlaceScreen::class.java)
//                            }
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
                            Column(){
                                Text(
                                    text = "시급      ",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                        fontWeight = FontWeight(700),
                                        color = gray01,
                                    )
                                )
                                Text(
                                    text = "11,000원    ",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                        fontWeight = FontWeight(700),
                                        color = Color(0xFFF17070),
                                    )
                                )
                            }
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
//                            .clickable {
//                                navigateToAnotherActivity(context, GigjobPostsActivity::class.java)
//                            },
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
                            Column(){
                                Text(
                                    text = "기간      ",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                        fontWeight = FontWeight(700),
                                        color = gray01,
                                    )
                                )
                                Text(
                                    text = "하루 ~ 1주일",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                        fontWeight = FontWeight(700),
                                        color = gray01,
                                    )
                                )
                            }
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
                                painter = painterResource(id = R.drawable.scheduler),
                                contentDescription = "image description",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(pink)
                            )
                            Column(){
                                Text(
                                    text = "요일      ",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                        fontWeight = FontWeight(700),
                                        color = gray01,
                                    )
                                )
                                Text(
                                    text = "월요일        ",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                        fontWeight = FontWeight(700),
                                        color = gray01,
                                    )
                                )
                            }
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
                            Column(){
                                Text(
                                    text = "시간      ",
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                                        fontWeight = FontWeight(700),
                                        color = gray01,
                                    )
                                )
                                Text(
                                    text = "12:00 ~ 15:00 ",
                                    style = TextStyle(
                                        fontSize = 11.sp,
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
        }
        Spacer(modifier = Modifier.height(32.dp))
        workCondition()
        Spacer(modifier = Modifier.height(32.dp))
        detailInfo()
        Spacer(modifier = Modifier.height(23.dp))
        applyButton()
    }
}

@Composable
private fun workCondition(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ){
        Column(
            modifier = Modifier
                .offset(x = 25.dp)
        ){
            Text(text = "근무조건",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                    fontWeight = FontWeight(1000),
                    color = Color.Black,
                ))
            Spacer(modifier = Modifier.height(20.dp))
            Row(){
                Text(
                    text = "급여      ",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                    )
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "시급 : ",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(700),
                        color = gray01,
                    )
                )
                Text(
                    text = "11,000원      ",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(700),
                        color = gray01,
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(){
                Text(
                    text = "근무기간",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                    )
                )
                Spacer(modifier = Modifier.width(17.dp))
                Text(
                    text = "2023-11-29 ~ 2023-11-30",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(700),
                        color = gray01,
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(){
                Text(
                    text = "근무요일",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                    )
                )
                Spacer(modifier = Modifier.width(17.dp))
                Text(
                    text = "월요일",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(700),
                        color = gray01,
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(){
                Text(
                    text = "근무시간",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                    )
                )
                Spacer(modifier = Modifier.width(17.dp))
                Text(
                    text = "12:00 ~ 15:00",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(700),
                        color = gray01,
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(){
                Text(
                    text = "업직종   ",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                    )
                )
                Spacer(modifier = Modifier.width(18.dp))
                Text(
                    text = "주방,요리",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(700),
                        color = gray01,
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(){
                Text(
                    text = "주소     ",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(500),
                        color = Color.Gray,
                    )
                )
                Spacer(modifier = Modifier.width(18.dp))
                Text(
                    text = "서울특별시 동작구 상도동 505-5",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(700),
                        color = gray01,
                    )
                )
            }
        }
    }
}

@Composable
private fun detailInfo(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .offset(x = 25.dp)
            ) {
                Text(
                    text = "상세 정보",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.nanumgothic)),
                        fontWeight = FontWeight(1000),
                        color = Color.Black,
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Text("상세 정보")
        Text("맥도날드 경력자 우대")
        Text("시간 잘 지켜서 와주세요")
    }
}

@Composable
private fun applyButton(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        // 모서리가 둥근 직사각형 그리기
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFFF17070))
                .clickable {}
        ) {
            Text(
                text = "지원하기",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                    fontWeight = FontWeight(500),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .offset( y= 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun mainInfoPreview(){
    mainInfo()
}