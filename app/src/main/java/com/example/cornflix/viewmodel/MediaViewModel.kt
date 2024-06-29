package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.MediaResponse
import com.example.cornflix.model.movie.Movie
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface MediaUiState {
    data class Success(val result: MediaResponse<Movie>) : MediaUiState
    object Error : MediaUiState
    object Loading : MediaUiState
}

class MediaViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var moviesUiState: MediaUiState by mutableStateOf(MediaUiState.Loading)
        private set

    init {
        getMedias()
    }

    fun getMedias() {

        viewModelScope.launch {
            moviesUiState = MediaUiState.Loading
            moviesUiState = try {
                val result = RetrofitService.retrofitService.getPopularMovies()
                MediaUiState.Success(result)
            } catch (e: IOException) {
                MediaUiState.Error
            } catch (e: HttpException) {
                MediaUiState.Error
            }
        }
    }
}