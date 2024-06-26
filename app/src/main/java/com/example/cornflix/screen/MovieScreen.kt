package com.example.cornflix.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cornflix.components.LazyColumnMedia
import com.example.cornflix.viewmodel.MoviesUiState


@Composable
fun MovieScreen(
    innerPadding: PaddingValues,
    moviesUiState: MoviesUiState,
    navController: NavController,
    modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding())) {

        when (moviesUiState) {
            is MoviesUiState.Success -> LazyColumnMedia(navController, moviesUiState.result.results)
            is MoviesUiState.Error -> {}
            is MoviesUiState.Loading -> {}
        }
    }
}