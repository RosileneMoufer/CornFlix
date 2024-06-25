package com.example.cornflix.components.buttons.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cornflix.R

@Composable
fun LogoButton(iconHeight: Dp){
    IconButton(modifier = Modifier.size(iconHeight),
        onClick = { /*TODO*/ }) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.popcorn),
            contentDescription = "logo"
        )
    }
}