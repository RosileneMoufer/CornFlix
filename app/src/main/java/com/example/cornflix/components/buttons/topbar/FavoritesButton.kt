package com.example.cornflix.components.buttons.topbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import com.example.cornflix.constants.ItemsMenu
import com.example.cornflix.ui.theme.favorite

@Composable
fun FavoriteButton(iconHeight: Dp, navController: NavHostController){
    IconButton(modifier = Modifier.size(iconHeight),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = favorite,
        ),
        onClick = { navController.navigate(ItemsMenu.FAVORITES.name) }) {
        Icon(modifier = Modifier.fillMaxSize(),
            imageVector = Icons.Default.Favorite,
            contentDescription = "Favorite",
        )
    }
}
//Apenas um escopo