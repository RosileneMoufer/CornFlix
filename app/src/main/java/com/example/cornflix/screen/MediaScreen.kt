package com.example.cornflix.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cornflix.components.LazyColumnMedia
import com.example.cornflix.viewmodel.MediaUiState

@Composable
fun MediaScreen(
    innerPadding: PaddingValues,
    mediaUiState: MediaUiState,
    navController: NavController,
    modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding())) {
        when (mediaUiState) {
            is MediaUiState.Success -> {
                val result = mediaUiState.moviesResult.results + mediaUiState.seriesResult.results
                val sorted = result.sortedBy { it.voteAverage }

                LazyColumnMedia(navController, sorted)
            }
            is MediaUiState.Error -> {}
            is MediaUiState.Loading -> {}
        }
    }
}