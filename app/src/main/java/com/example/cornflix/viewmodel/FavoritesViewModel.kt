package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.favorites.FavoriteBody
import com.example.cornflix.model.favorites.FavoritesResponse
import com.example.cornflix.model.media.MediaType
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface FavoritesUiState {
    data class AddSuccess(val result: FavoritesResponse) : FavoritesUiState
    data class GetSuccess(val result: FavoritesResponse) : FavoritesUiState
    data object Error : FavoritesUiState
    data object Loading : FavoritesUiState
}

class FavoritesViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var favoritesUiState: FavoritesUiState by mutableStateOf(FavoritesUiState.Loading)
        private set

    init {
        //getSeries()
    }
/*
    private fun getSeries() {
        viewModelScope.launch {
            seriesUiState = FavoritesUiState.Loading
            seriesUiState = try {
                val result = RetrofitService.retrofitService.getFavorites()
                FavoritesUiState.GetSuccess(result)
            } catch (e: IOException) {
                FavoritesUiState.Error
            } catch (e: HttpException) {
                FavoritesUiState.Error
            }
        }
    }
*/
    fun addFavorites(mediaId:Int, mediaType: MediaType) {
        viewModelScope.launch {
            favoritesUiState = try {
                val body = FavoriteBody(
                    true,
                    mediaId,
                    if (mediaType == MediaType.Movie) "movie" else "serie"
                )

                val result = RetrofitService.retrofitService.addFavorites(body)
                FavoritesUiState.AddSuccess(result)
            }catch (e: IOException) {
                FavoritesUiState.Error
            }
            catch (e: HttpException) {
                FavoritesUiState.Error
            }
        }
    }
}