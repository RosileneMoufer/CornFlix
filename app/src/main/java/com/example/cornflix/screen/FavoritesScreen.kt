package com.example.cornflix.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cornflix.components.LazyColumnMedia
import com.example.cornflix.viewmodel.GetFavoritesUiState
import com.example.cornflix.viewmodel.MoviesUiState

@Composable
fun FavoritesScreen(
    innerPadding: PaddingValues,
    favoritesUiState: GetFavoritesUiState,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    Surface(modifier = modifier
        .fillMaxSize()
        .padding(top = innerPadding.calculateTopPadding())) {

        when (favoritesUiState) {
            is GetFavoritesUiState.GetSuccess -> {
                val result = favoritesUiState.moviesResult.results + favoritesUiState.seriesResult.results
                val sorted = result.sortedBy { it.voteAverage }

                //LazyColumnMedia(navController, sorted)
            }
            is GetFavoritesUiState.Error -> {}
            is GetFavoritesUiState.Loading -> {}
        }
    }
}