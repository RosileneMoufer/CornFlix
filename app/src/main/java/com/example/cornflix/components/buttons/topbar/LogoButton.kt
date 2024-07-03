package com.example.cornflix.components.buttons.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.example.cornflix.R
import com.example.cornflix.constants.ItemsMenu

@Composable
fun LogoButton(iconHeight: Dp, navController: NavController){
    IconButton(modifier = Modifier.size(iconHeight),
        onClick = { navController.navigate(ItemsMenu.HOME.name) }) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.popcorn),
            contentDescription = "logo"
        )
    }
}