package com.example.cornflix.components.buttons.topbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cornflix.ui.theme.menuButton

@Preview
@Composable
fun MenuButton(){
    IconButton(modifier = Modifier.size(300.dp),
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = menuButton,
        ),
        onClick = { /*TODO*/ }) {
        Icon(modifier = Modifier.size(300.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = "Favorite",
        )
    }
}
//Apenas um escopo