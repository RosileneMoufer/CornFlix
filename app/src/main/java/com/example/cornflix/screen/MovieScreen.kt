package com.example.cornflix.screen

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cornflix.components.LazyVerticalGridMovies
import com.example.cornflix.viewmodel.MoviesUiState


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieScreen(
    innerPadding: PaddingValues,
    moviesUiState: MoviesUiState,
    modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding())) {

        when (moviesUiState) {
            is MoviesUiState.Success -> LazyVerticalGridMovies(moviesUiState.result.results)
            is MoviesUiState.Error -> {}
            is MoviesUiState.Loading -> {}
        }
    }
}