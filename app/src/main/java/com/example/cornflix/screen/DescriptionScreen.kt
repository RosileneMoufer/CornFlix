package com.example.cornflix.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cornflix.R
import com.example.cornflix.components.FloatingMessage
import com.example.cornflix.components.buttons.SaveButton
import com.example.cornflix.components.buttons.TrailerButton
import com.example.cornflix.ui.theme.detailsTextColor
import com.example.cornflix.ui.theme.primary
import com.example.cornflix.ui.theme.secondary
import com.example.cornflix.ui.theme.textColor
import com.example.cornflix.ui.theme.transparent

@Composable
fun DescriptionScreen() {

    val description = arrayListOf(
        "Nome do filme", "ANO", "NOTA", "DURAÇÃO",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.movie), contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        startX = 150F,
                        colors = listOf(
                            primary,
                            transparent
                        )
                    )
                )
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically
            ),
        ) {
            // movie title
            Text(
                text = description[0],
                style = TextStyle(
                    fontSize = 32.sp, fontWeight = FontWeight.W700,
                    lineHeight = 22.sp,
                    color = textColor
                )
            )

            //details
            Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                Text(
                    text = description[1], style = TextStyle(
                        color = detailsTextColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                    )
                )
                Text(
                    text = description[2], style = TextStyle(
                        color = secondary,
                        fontSize = 12.sp, fontWeight = FontWeight.W600,
                    )
                )
                Text(
                    text = "|   " + description[3], style = TextStyle(
                        color = detailsTextColor,
                        fontSize = 12.sp, fontWeight = FontWeight.W600,
                    )
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // title description
            Text(
                text = description[4],
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700, lineHeight = 24.sp, color = textColor
                )
            )

            Spacer(modifier = Modifier.height(2.dp))

            // description
            Text(
                text = description[5],
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600, lineHeight = 20.sp, color = textColor
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            // buttons
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                TrailerButton()
                SaveButton()
            }

        }

    }
}