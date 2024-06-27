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
import com.example.cornflix.viewmodel.SeriesUiState


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SeriesScreen(
    innerPadding: PaddingValues,
    seriesUiState: SeriesUiState,
    modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding())) {
/*
        when (seriesUiState) {
            is SeriesUiState.Success -> LazyVerticalGridMovies(seriesUiState.result.results)
            is SeriesUiState.Error -> {}
            is SeriesUiState.Loading -> {}
        }*/
    }
}