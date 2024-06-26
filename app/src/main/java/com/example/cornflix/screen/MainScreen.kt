package com.example.cornflix.screen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(logOutAction: ()->Unit) {
    val navController = rememberNavController()
    //val bottomMenuViewModel = viewModel<BottomMenuViewModel>()

    TopBarController(navController)
}

@Composable
fun TopBarController(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "courses") {
        //composable("courses") { FavoritesScreen() }
        //composable("classes") { DescriptionScreen() }
    }
}