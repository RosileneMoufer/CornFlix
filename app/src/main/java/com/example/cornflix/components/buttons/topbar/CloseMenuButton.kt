package com.example.cornflix.components.buttons.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cornflix.ui.theme.closeButton
import com.example.cornflix.ui.theme.menuButton

@Composable
fun CloseMenuButton(iconHeight: Dp, onClick: () -> Unit){
    IconButton(
        modifier = Modifier
            .size(iconHeight)
            .background(color = closeButton,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(8.dp),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = menuButton,
        ),
        onClick = onClick) {
        Icon(modifier = Modifier
            .fillMaxSize(),
            imageVector = Icons.Filled.Close,
            contentDescription = "Favorite",
        )
    }
}