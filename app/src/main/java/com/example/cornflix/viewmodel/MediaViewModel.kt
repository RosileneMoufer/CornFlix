package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.MediaModel
import com.example.cornflix.model.MediaResponse
import com.example.cornflix.model.movie.Movie
import com.example.cornflix.model.series.Series
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface MediaUiState {
    data class Success(
        val moviesResult: MediaResponse<Movie>,
        val seriesResult: MediaResponse<Series>
    ) : MediaUiState

    data object Error : MediaUiState
    data object Loading : MediaUiState
}

class MediaViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var mediaUiState: MediaUiState by mutableStateOf(MediaUiState.Loading)
        private set

    init {
        getMedias()
    }

    private fun getMedias() {
        viewModelScope.launch {
            mediaUiState = MediaUiState.Loading
            mediaUiState = try {
                val moviesResult = RetrofitService.retrofitService.getPopularMovies()
                val seriesResult = RetrofitService.retrofitService.getPopularSeries()

                MediaUiState.Success(moviesResult, seriesResult)
            } catch (e: IOException) {
                MediaUiState.Error
            } catch (e: HttpException) {
                MediaUiState.Error
            }
        }
    }
}