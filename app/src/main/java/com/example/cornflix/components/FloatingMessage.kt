package com.example.cornflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.cornflix.ui.theme.secondary
import com.example.cornflix.ui.theme.textColor

@Composable
fun FloatingMessage() {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(secondary)
        .padding(14.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Adicionado na sua lista!", style = TextStyle(color = textColor))
            Text(text = "x", style = TextStyle(color = textColor), modifier = Modifier.clickable { /* TODO */ })
        }
    }
}