package com.example.myalbaez.ui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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

}

@Composable
private fun mainInfo(){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        Spacer(modifier = Modifier.height(23.dp))
        Column(

        ){
            Text(
                modifier = Modifier
                    .offset(x = 10.dp),
                text = "[임시]계약직 채용",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.nanumgothic)),
                    fontWeight = FontWeight(700),
                    color = gray01,
                )
            )
            Spacer(modifier = Modifier.height(23.dp))
            Row(){
                Image(
                    painter = painterResource(id =R.drawable.a),
                    modifier = Modifier
                        .offset(x = 20.dp)
                        .size(32.dp)
                        .clip(CircleShape),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(

                    modifier = Modifier
                        .offset(x = 10.dp)
                        .align(Alignment.CenterVertically),
                    text = "알바이지",
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
                            .clickable {
                                navigateToAnotherActivity(context, WorkPlaceScreen::class.java)
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
                                text = "시급      ",
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
                                text = "기간      ",
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
                                text = "요일      ",
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
                                text = "시간      ",
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
        }
    }
}

@Composable
private fun workCondition(){

}

@Composable
private fun detailInfo(){

}

@Preview
@Composable
private fun mainInfoPreview(){
    mainInfo()
}