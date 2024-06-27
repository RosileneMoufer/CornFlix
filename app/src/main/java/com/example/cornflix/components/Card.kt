package com.example.cornflix.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cornflix.models.MediaModel
import com.example.cornflix.models.movie.MoviesModel
import java.util.Objects

@Composable
fun Card(movie: MoviesModel,) {
    val moviePoster = movie.posterMovie
    AsyncImage(
        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(8.dp)),
        model =
        ImageRequest.Builder(context = LocalContext.current)
            .data("https://image.tmdb.org/t/p/original$moviePoster")
            .crossfade(true).build(),
        contentDescription = movie.nameMovie,
        contentScale = ContentScale.Crop,

    )
}