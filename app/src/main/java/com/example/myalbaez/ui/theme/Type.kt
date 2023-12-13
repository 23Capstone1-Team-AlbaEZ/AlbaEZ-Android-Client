package com.example.myalbaez.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myalbaez.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

/*val provider = GoogleFont.Provider(
    providerAuthority = ,

)*/

val gigJobPostTypo = Typography(
    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.nanumgothic)),
        fontWeight = FontWeight(400),
        fontSize = 10.sp,
        color = gray01
    ),
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.nanumgothic)),
        fontWeight = FontWeight(700),
        fontSize = 12.sp,
        color = gray01
    )
)

