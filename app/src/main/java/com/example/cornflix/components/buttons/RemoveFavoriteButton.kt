package com.example.cornflix.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RemoveFavoriteButton(iconHeight: Dp, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(iconHeight)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red, shape = CircleShape)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(2.dp, Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Remove from Favorite List",
                    tint = Color.White,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}