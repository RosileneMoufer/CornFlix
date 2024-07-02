package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.favorites.FavoriteBody
import com.example.cornflix.model.favorites.FavoritesResponse
import com.example.cornflix.model.media.MediaModel
import com.example.cornflix.model.media.MediaResponse
import com.example.cornflix.model.media.MediaType
import com.example.cornflix.model.movie.Movie
import com.example.cornflix.model.series.Series
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AddFavoritesUiState {
    data class AddSuccess(val result: FavoritesResponse) : AddFavoritesUiState
    data object Error : AddFavoritesUiState
    data object Loading : AddFavoritesUiState
}

sealed interface GetFavoritesUiState {
    data class GetSuccess(
        val moviesResult: MediaResponse<Movie>,
        val seriesResult: MediaResponse<Series>
    ) : GetFavoritesUiState

    data object Error : GetFavoritesUiState
    data object Loading : GetFavoritesUiState
}

class FavoritesViewModel : ViewModel() {

    private val _addFavorite = MutableLiveData(AddFavoritesUiState.Loading)
    val addFavorite: MutableLiveData<AddFavoritesUiState.Loading> = _addFavorite


    var addFavoritesUiState: AddFavoritesUiState by mutableStateOf(AddFavoritesUiState.Loading)
        private set
    var getFavoritesUiState: GetFavoritesUiState by mutableStateOf(GetFavoritesUiState.Loading)
        private set

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch {
            getFavoritesUiState = try {
                val resultFavoritesMovie = RetrofitService.retrofitService.getFavoritesMovie()
                val resultFavoritesSeries = RetrofitService.retrofitService.getFavoritesSeries()

                GetFavoritesUiState.GetSuccess(resultFavoritesMovie, resultFavoritesSeries)
            } catch (e: IOException) {
                GetFavoritesUiState.Error
            } catch (e: HttpException) {
                GetFavoritesUiState.Error
            }
        }
    }

    fun addFavorites(mediaId: String, mediaType: String) {
        viewModelScope.launch {
            addFavoritesUiState = try {
                val body = FavoriteBody(
                    true,
                    mediaId,
                    mediaType
                )

                val result = RetrofitService.retrofitService.addFavorites(body)
                AddFavoritesUiState.AddSuccess(result)
            } catch (e: IOException) {
                AddFavoritesUiState.Error
            } catch (e: HttpException) {
                AddFavoritesUiState.Error
            }
        }
    }

    fun removeFavorites(mediaId: String, mediaType: String) {
        viewModelScope.launch {
            addFavoritesUiState = try {
                val body = FavoriteBody(
                    false,
                    mediaId,
                    mediaType
                )

                val result = RetrofitService.retrofitService.addFavorites(body)
                AddFavoritesUiState.AddSuccess(result)
            } catch (e: IOException) {
                AddFavoritesUiState.Error
            } catch (e: HttpException) {
                AddFavoritesUiState.Error
            }
        }
    }
}