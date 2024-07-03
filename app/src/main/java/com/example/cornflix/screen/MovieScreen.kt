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
import com.example.cornflix.viewmodel.MoviesViewModel


@Composable
fun MovieScreen(
    innerPadding: PaddingValues,
    moviesUiState: MoviesUiState,
    navController: NavController,
    moviesViewModel: MoviesViewModel,
    modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding())) {
        when (moviesUiState) {
            is MoviesUiState.Success -> LazyColumnMedia(navController, moviesViewModel)
            is MoviesUiState.Error -> {}
            is MoviesUiState.Loading -> {}
        }
    }
}