package com.example.cornflix.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cornflix.components.LazyColumnMedia
import com.example.cornflix.viewmodel.SeriesUiState


@Composable
fun SeriesScreen(
    innerPadding: PaddingValues,
    seriesUiState: SeriesUiState,
    navController: NavController,
    modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding())) {

        when (seriesUiState) {
            is SeriesUiState.Success -> LazyColumnMedia(navController, seriesUiState.result.results)
            is SeriesUiState.Error -> {}
            is SeriesUiState.Loading -> {}
        }
    }
}