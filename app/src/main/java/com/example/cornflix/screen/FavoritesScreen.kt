package com.example.cornflix.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cornflix.components.LazyColumnMedia
import com.example.cornflix.viewmodel.FavoritesViewModel
import com.example.cornflix.viewmodel.GetFavoritesUiState

@Composable
fun FavoritesScreen(
    innerPadding: PaddingValues,
    navController: NavController,
    favoritesViewModel: FavoritesViewModel,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier
        .fillMaxSize()
        .padding(top = innerPadding.calculateTopPadding())) {

        when (favoritesViewModel.getFavoritesUiState) {
            is GetFavoritesUiState.Success -> {
                LazyColumnMedia(navController, favoritesViewModel)
            }

            is GetFavoritesUiState.Error -> {}
            is GetFavoritesUiState.Loading -> {}
        }
    }
}