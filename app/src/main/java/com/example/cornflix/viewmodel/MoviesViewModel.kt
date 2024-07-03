package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.media.MediaModel
import com.example.cornflix.model.movie.Movie
import com.example.cornflix.model.trailer.TrailerResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MoviesUiState {
    data class Success(val result: List<MediaModel>) : MoviesUiState
    data object Error : MoviesUiState
    data object Loading : MoviesUiState
}


class MoviesViewModel : DefaultViewModel() {
    override var mediaType = "movie"

    var moviesUiState: MoviesUiState by mutableStateOf(MoviesUiState.Loading)
        private set

    init {
        //getMovies()
        getMoreMedias(1)
    }
/*
    fun getMovies() {
        viewModelScope.launch {
            moviesUiState = MoviesUiState.Loading
            moviesUiState = try {
                val result = RetrofitService.retrofitService.getPopularMovies()
                MoviesUiState.Success(result.results)
            } catch (e: IOException) {
                MoviesUiState.Error
            } catch (e: HttpException) {
                MoviesUiState.Error
            }
        }
    }
*/

    override fun getMoreMedias(page : Int) {
        viewModelScope.launch {
            //moviesUiState = MoviesUiState.Loading
            moviesUiState = try {
                val result = RetrofitService.retrofitService.getPopularMovies(page)
                defaultListResponse = defaultListResponse + result.results

                MoviesUiState.Success(defaultListResponse)
            } catch (e: IOException) {
                MoviesUiState.Error
            } catch (e: HttpException) {
                MoviesUiState.Error
            }
        }
    }
/*
    fun getMovie(movieId : String) {
        viewModelScope.launch {
            moviesUiState = try {
                val result = RetrofitService.retrofitService.getMovie(movieId)

                MovieTrailerUiState.Success(result)
            } catch (e: IOException) {
                MovieTrailerUiState.Error
            } catch (e: HttpException) {
                MovieTrailerUiState.Error
            }
        }
    }*/
}