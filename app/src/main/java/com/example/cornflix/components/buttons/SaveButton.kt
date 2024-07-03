package com.example.cornflix.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cornflix.constants.RequestStatus
import com.example.cornflix.ui.theme.textColor
import com.example.cornflix.ui.theme.transparent
import com.example.cornflix.viewmodel.FavoritesViewModel
import kotlinx.coroutines.launch

@Composable
fun SaveButton(
    mediaId: String,
    mediaType: String,
    favoritesViewModel: FavoritesViewModel,
    snackbarHostState: SnackbarHostState,
) {
    val scope = rememberCoroutineScope()
    val status by favoritesViewModel.status.collectAsState()

    LaunchedEffect(key1 = status, block = {
        if (status == RequestStatus.SUCCESS) {
            snackbarHostState.showSnackbar(
                message = "Snackbar",
                actionLabel = "Action",
                duration = SnackbarDuration.Indefinite
            )
        }
    })

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(transparent)
            .border(2.dp, color = textColor, shape = RoundedCornerShape(8.dp))
            .clickable {
                val type = if (mediaType.contains("movie")) {
                    "movie"
                } else {
                    "tv"
                }

                scope.launch {
                    favoritesViewModel.addFavorites(mediaId, mediaType = type)
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                modifier = Modifier.padding(
                    start = 12.dp,
                    top = 12.dp,
                    end = 16.dp,
                    bottom = 12.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Salvar",
                    tint = textColor
                )
                Text(
                    text = "Salvar", style = TextStyle(
                        color = textColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W600
                    )
                )
            }
        }
    }
}