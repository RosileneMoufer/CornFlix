package com.example.cornflix.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.cornflix.constants.ItemsMenu
import com.example.cornflix.model.MediaModel

@Composable
fun Card(media: MediaModel, navController: NavController) {
    val mediaPoster = media.poster
    AsyncImage(
        modifier = Modifier.fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .clickable { navController.navigate(ItemsMenu.Details.name) },
        model = ImageRequest.Builder(context = LocalContext.current)
            .data("https://image.tmdb.org/t/p/original$mediaPoster")
            .crossfade(true).build(),
        contentDescription = media.name,
        contentScale = ContentScale.Crop,
    )
}