package com.example.cornflix.components.buttons.topbar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.cornflix.ui.theme.menuButton

@Composable
fun MenuButton(iconHeight: Dp, onClick: () -> Unit){
    IconButton(modifier = Modifier.size(iconHeight),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = menuButton,
        ),
        onClick =  onClick ) {
        Icon(modifier = Modifier.fillMaxSize(),
            imageVector = Icons.Default.Menu,
            contentDescription = "Favorite",
        )
    }
}
//Apenas um escopo