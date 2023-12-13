package com.example.myalbaez.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    color = Color.White
                ) {
                    coWorkerCards()

                }
        }
    }
}

@Composable
private fun coWorkerCards(){
    // ResourcePainter를 사용하여 Painter 생성
    val imagePainter: Painter = painterResource(id = R.drawable.profile)
    Column(
    ){
        coWorkerCardRow(imagePainter, "memberId1")
        Spacer(modifier = Modifier.height(64.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter, "memberId2")
        Spacer(modifier = Modifier.height(64.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter, "memberId3")
        Spacer(modifier = Modifier.height(64.dp)) // Row 사이의 간격을 설정합니다.
        coWorkerCardRow(imagePainter, "memberId4")
    }
}

@Composable
private fun coWorkerCardRow(image: Painter, memberId: String) {
    Row(
        modifier = Modifier
            .background(Color.Gray)
    ){
        coWorkerCardCol(image, memberId)
        Spacer(modifier = Modifier.height(32.dp)) // Col 사이의 간격을 설정합니다.
        coWorkerCardCol(image, memberId)
        Spacer(modifier = Modifier.height(32.dp))
        coWorkerCardCol(image, memberId)
    }
}

@Composable
private fun coWorkerCardCol(image: Painter, memberId: String){
    var condition: Boolean = true
    val borderModifier = if (condition) {
        Modifier.border(width = 4.dp, color = Color.White, shape = RoundedCornerShape(size = 84.dp))
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
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview
@Composable
private fun coWorkerCardPreview(){
    coWorkerCards()
}