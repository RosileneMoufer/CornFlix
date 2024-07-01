package com.example.cornflix.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cornflix.ui.theme.textColor
import com.example.cornflix.ui.theme.transparent
import com.example.cornflix.viewmodel.FavoritesViewModel
import com.example.cornflix.viewmodel.SeriesViewModel

@Composable
fun SaveButton(mediaId : String) {
    val favoritesViewModel: FavoritesViewModel = viewModel()

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(transparent)
            .border(2.dp, color = textColor, shape = RoundedCornerShape(8.dp))
            .clickable {

                favoritesViewModel.addFavorites(mediaId, )

            },
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
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