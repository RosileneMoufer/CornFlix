package com.example.cornflix.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cornflix.components.buttons.topbar.CloseMenuButton
import com.example.cornflix.components.buttons.topbar.FavoriteButton
import com.example.cornflix.components.buttons.topbar.LogoButton
import com.example.cornflix.components.buttons.topbar.MenuButton
import com.example.cornflix.ui.theme.primary

@Preview
@Composable
fun TopAppBar() {
    val mySize = 35.dp
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(primary)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MenuButton(mySize)
        CloseMenuButton(mySize)
        LogoButton(mySize)
        FavoriteButton(mySize)
    }
}