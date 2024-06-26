package com.example.cornflix.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cornflix.R

@Composable
fun Card(index : Int) {
    Image(
        modifier = Modifier.clip(RoundedCornerShape(8.dp)),
        painter = painterResource(id = R.drawable.movie),
        contentDescription = "cartaz",
    )
}