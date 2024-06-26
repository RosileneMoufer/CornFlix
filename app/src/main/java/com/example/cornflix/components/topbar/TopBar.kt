package com.example.cornflix.components.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cornflix.components.buttons.topbar.CloseMenuButton
import com.example.cornflix.components.buttons.topbar.FavoriteButton
import com.example.cornflix.components.buttons.topbar.LogoButton
import com.example.cornflix.components.buttons.topbar.MenuButton
import com.example.cornflix.ui.theme.primary

@Composable
fun TopAppBar() {
    val mySize = 35.dp
    var showMenuIcon by remember { mutableStateOf(true)}
    //val showMenuIcon by viewModel.showMenuIcon.collectAsState()
    var expanded by remember { mutableStateOf(false)}
    //val expanded by viewModel.expanded.collectAsState()
    Column(
        modifier = Modifier
            .background(primary)
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showMenuIcon) {
                MenuButton(
                    mySize,
                    onClick = {
                        showMenuIcon = false
                        expanded = true
                    })
            } else {
                CloseMenuButton(
                    mySize,
                    onClick = {
                        showMenuIcon = true
                        expanded = false
                    })
            }
            LogoButton(mySize)
            FavoriteButton(mySize)
        }
        if(expanded){
            Text(
                text = "Home",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { /* Handle click for Text */ }
            )
            Text(
                text = "Filmes",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { /* Handle click for Text */ }
            )
            Text(
                text = "Séries",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { /* Handle click for Text */ }
            )
        }
    }
}