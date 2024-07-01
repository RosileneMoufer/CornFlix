package com.example.cornflix.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cornflix.components.buttons.SaveButton
import com.example.cornflix.components.buttons.TrailerButton
import com.example.cornflix.ui.theme.detailsTextColor
import com.example.cornflix.ui.theme.primary
import com.example.cornflix.ui.theme.secondary
import com.example.cornflix.ui.theme.textColor
import com.example.cornflix.ui.theme.transparent
import com.example.cornflix.model.media.MediaModel

@Composable
fun DetailsMediaScreen(paddingValues: PaddingValues, mediaModel: MediaModel) {
    val mediaType = mediaModel.javaClass.name
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = paddingValues.calculateTopPadding()),
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(context = LocalContext.current)
                .data("https://image.tmdb.org/t/p/original${mediaModel.poster}")
                .crossfade(true).build(),
            contentDescription = mediaModel.name,
            contentScale = ContentScale.Crop,
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
                text = mediaModel.name,
                style = TextStyle(
                    fontSize = 32.sp, fontWeight = FontWeight.W700,
                    lineHeight = 42.sp,
                    color = textColor
                )
            )

            //details
            Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                Text(
                    text = mediaModel.releaseDate, style = TextStyle(
                        color = detailsTextColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                    )
                )
                Text(
                    text = mediaModel.voteAverage, style = TextStyle(
                        color = secondary,
                        fontSize = 12.sp, fontWeight = FontWeight.W600,
                    )
                )
                Text(
                    text = "|   " + mediaModel.name, style = TextStyle(
                        color = detailsTextColor,
                        fontSize = 12.sp, fontWeight = FontWeight.W600,
                    )
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // title description
            Text(
                text = mediaModel.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700, lineHeight = 24.sp, color = textColor
                )
            )

            Spacer(modifier = Modifier.height(2.dp))

            // description
            Text(
                text = mediaModel.description,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600, lineHeight = 20.sp, color = textColor
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            // buttons
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                TrailerButton()
                SaveButton(mediaModel.id)
            }

        }

    }
}