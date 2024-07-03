package com.example.cornflix.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import com.example.cornflix.api.IMAGE_URL
import com.example.cornflix.components.buttons.RemoveFavoriteButton
import com.example.cornflix.constants.ItemsMenu
import com.example.cornflix.model.media.MediaModel
import com.example.cornflix.viewmodel.DefaultViewModel
import com.example.cornflix.viewmodel.FavoritesViewModel

@Composable
fun Card(
    mediaModel: MediaModel,
    navController: NavController,
    defaultViewModel: DefaultViewModel? = null
) {
    Box() {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
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
        if (defaultViewModel != null) RemoveFavoriteButton(iconHeight = 32.dp,
            onClick = {
                val type = if (mediaModel.javaClass.name.lowercase().contains("movie")) {
                    "movie"
                } else {
                    "tv"
                }

                defaultViewModel.removeFavorites(
                    mediaId = mediaModel.id,
                    mediaType = type
                )
            })
    }

}