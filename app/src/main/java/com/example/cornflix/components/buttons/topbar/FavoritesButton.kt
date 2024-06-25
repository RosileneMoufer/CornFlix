package com.example.cornflix.components.buttons.topbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cornflix.ui.theme.selectedMenu

@Composable
fun FavoriteButton(iconHeight: Dp){
    IconButton(modifier = Modifier.size(iconHeight),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = selectedMenu,
        ),
        onClick = { /*TODO*/ }) {
        Icon(modifier = Modifier.fillMaxSize(),
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite",
        )
    }
}
//Apenas um escopo