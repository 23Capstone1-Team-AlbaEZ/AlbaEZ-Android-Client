package com.example.myalbaez.ui.screens.gigjobposts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myalbaez.ui.screens.gigjobposts.dataClass.gigjobPost
import com.example.myalbaez.ui.theme.gigJobPostTypo
import com.example.myalbaez.ui.theme.gray02
import com.example.myalbaez.ui.theme.gray05
import com.example.myalbaez.ui.theme.pink
import com.example.myalbaez.ui.theme.pure_white
import com.example.myalbaez.ui.theme.purple
import com.example.myalbaez.ui.theme.white
import com.example.myalbaez.ui.theme.yellow
import com.google.gson.Gson
import java.io.InputStreamReader

class GigjobPostsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = white
            ) {
                val jsonData = assets.open("gigjobPostsListData.json")
                    .use { InputStreamReader(it).readText() }

                val gson = Gson()
                val cardList: List<gigjobPost> =
                    gson.fromJson(jsonData, Array<gigjobPost>::class.java).toList()

                GigJobPostsScreen(cards = cardList)
            }
        }
    }
}

@Composable
fun GigJobPostsScreen(cards: List<gigjobPost>){
    Column(){
        Column(
            modifier = Modifier.padding(35.dp)
        ){
            Text(
                text="긱잡 채용 정보",
                style= gigJobPostTypo.displayLarge,
                fontSize = 20.sp,
                color=gray05,
                letterSpacing = 0.4.sp,
            )
            Spacer(modifier=Modifier.height(31.dp))
            Text(
                buildAnnotatedString{
                    withStyle(
                        style= SpanStyle(color= pink)
                    ){
                        append(cards.size.toString())
                    }
                    append("건의 공고가 새로 올라왔어요")
                }
            )
        }
        JobPostsSlider(cards=cards)
    }
}

@Composable
fun JobPostsSlider(cards: List<gigjobPost>) {
    var scrollState by remember { mutableFloatStateOf(0f) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, _, _ ->
                    scrollState += pan.x
                }
            }
            .background(white),
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items(cards.size) {
            // Composable function for each card
            gigjobPostCard(card = cards[it])
        }
        /*item{
            LastCard()
        }*/
    }
}
@Composable
fun gigjobPostCard(card: gigjobPost) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = pure_white,
        ),
        modifier = Modifier.size(width = 340.dp, height = 133.dp),
        /*onClick = {
            클릭 시 card.gigjobPostID를 이용해 해당 page로 이동
        }*/
        ) {

        var _payFormColor: Color =
            when (card.payForm) {
                "시급" -> {
                    yellow
                }

                "일급" -> {
                    purple
                }

                else -> {
                    Color.Unspecified
                }
            }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = card.workplaceName,
                    style = gigJobPostTypo.displayMedium,
                )
                Text(
                    text = card.postDate,
                    style = gigJobPostTypo.displayMedium,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = card.content,
                style = gigJobPostTypo.displayLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.startTime + " ~ " + card.endTime,
                style = gigJobPostTypo.displayMedium,
                color = gray02
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = card.payForm,
                    style = gigJobPostTypo.displayMedium,
                    color = _payFormColor
                )
                Text(
                    text = card.pay,
                    style = gigJobPostTypo.displayMedium,
                    color = gray02
                )
            }
            Spacer(modifier = Modifier.height(13.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = card.address,
                style = gigJobPostTypo.displayMedium,
                color = gray02,
                textAlign = TextAlign.Right
            )
        }
    }
}


/*@Composable*/
/*fun LastCard(){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors=CardDefaults.cardColors(
            containerColor = Color(0xFFF17070),
        ),
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .size(width = 340.dp, height = 126.dp),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Left content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(4.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "User",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
            }

            // Right content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(4.dp),
                    tint = MaterialTheme.colorScheme.onSecondary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Information",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun GigJobPostsScreenPreview() {
    // Access the assets in the preview using LocalContext
    val jsonData = LocalContext.current.assets.open("gigjobPostsListData.json")
        .use { InputStreamReader(it).readText() }
    val gson = Gson()
    if(jsonData.isNotEmpty()) {
        val cardList: List<gigjobPost> = gson.fromJson(jsonData, Array<gigjobPost>::class.java).toList()
        GigJobPostsScreen(cards = cardList)
    }

}

