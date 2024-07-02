package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.media.MediaResponse
import com.example.cornflix.model.movie.Movie
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MoviesUiState {
    data class Success(val result: MediaResponse<Movie>) : MoviesUiState
    data object Error : MoviesUiState
    data object Loading : MoviesUiState
}

class MoviesViewModel : ViewModel() {
    var moviesUiState: MoviesUiState by mutableStateOf(MoviesUiState.Loading)
        private set

    var moviesListResponse : List<Movie> by mutableStateOf(listOf())
    private var lastOffset : Long by mutableStateOf(0.toLong())
    var errorMessage : String by mutableStateOf("")

    init {
        getMovies()
    }

    fun getMovies() {

        viewModelScope.launch {
            moviesUiState = MoviesUiState.Loading
            moviesUiState = try {
                val result = RetrofitService.retrofitService.getPopularMovies()
                MoviesUiState.Success(result)
            } catch (e: IOException) {
                MoviesUiState.Error
            } catch (e: HttpException) {
                MoviesUiState.Error
            }
        }
    }
}