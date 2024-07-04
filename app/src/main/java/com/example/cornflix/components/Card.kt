package com.example.cornflix.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import com.example.cornflix.api.IMAGE_URL
import com.example.cornflix.constants.ItemsMenu
import com.example.cornflix.model.media.MediaModel

@Composable
fun Card(
    mediaModel: MediaModel,
    navController: NavController,
) {
    AsyncImage(
        modifier = Modifier.width(330.dp).height(330.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "media",
                    value = mediaModel
                )
                navController.navigate(ItemsMenu.DETAILS.name)
            },
        model = ImageRequest.Builder(context = LocalContext.current)
            .data("$IMAGE_URL${mediaModel.poster}")
            .crossfade(true).build(),
        contentDescription = mediaModel.name,
        contentScale = ContentScale.Crop,
    )
}