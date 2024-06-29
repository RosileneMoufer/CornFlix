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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cornflix.components.buttons.topbar.CloseMenuButton
import com.example.cornflix.components.buttons.topbar.FavoriteButton
import com.example.cornflix.components.buttons.topbar.LogoButton
import com.example.cornflix.components.buttons.topbar.MenuButton
import com.example.cornflix.constants.ItemsMenu
import com.example.cornflix.ui.theme.primary
import com.example.cornflix.viewmodel.HomeScreenViewModel

@Composable
fun TopAppBar(navController: NavHostController, homeScreenViewModel: HomeScreenViewModel) {
    val mySize = 35.dp
    val showMenuIcon by homeScreenViewModel.showMenuIcon.observeAsState()
    val expanded by homeScreenViewModel.expanded.observeAsState()

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
            if (showMenuIcon == true) {
                MenuButton(
                    mySize,
                    onClick = {
                        //showMenuIcon = false
                        //expanded = true
                        homeScreenViewModel.changeIcon(showMi = false, expand = true)
                    })
            } else {
                CloseMenuButton(
                    mySize,
                    onClick = {
                        //showMenuIcon = true
                        //expanded = false
                        homeScreenViewModel.changeIcon(showMi = true, expand = false)
                    })
            }
            LogoButton(mySize, navController)
            FavoriteButton(mySize)
        }
        if(expanded == true){
            Text(
                text = "Home",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { navController.navigate(ItemsMenu.Home.name) }
            )
            Text(
                text = "Filmes",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { navController.navigate(ItemsMenu.Movies.name) }
            )
            Text(
                text = "Séries",
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { navController.navigate(ItemsMenu.Series.name) }
            )
        }
    }
}