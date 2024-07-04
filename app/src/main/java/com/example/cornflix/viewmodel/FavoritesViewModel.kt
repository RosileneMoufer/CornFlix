package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.constants.RequestStatus
import com.example.cornflix.model.favorites.FavoriteBody
import com.example.cornflix.model.favorites.FavoritesResponse
import com.example.cornflix.model.media.MediaModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface AddFavoritesUiState {
    data class Success(val result: FavoritesResponse) : AddFavoritesUiState
    data object Error : AddFavoritesUiState
    data object Loading : AddFavoritesUiState
}

sealed interface GetFavoritesUiState {
    data class Success(
        val mediaResult: List<MediaModel>,
    ) : GetFavoritesUiState

    data object Error : GetFavoritesUiState
    data object Loading : GetFavoritesUiState
}

class FavoritesViewModel : DefaultViewModel() {
    override var mediaType = "favorite"

    private val _status = MutableStateFlow(RequestStatus.LOADING)
    val status: StateFlow<RequestStatus> = _status

    var addFavoritesUiState: AddFavoritesUiState by mutableStateOf(AddFavoritesUiState.Loading)
        private set

    var getFavoritesUiState: GetFavoritesUiState by mutableStateOf(GetFavoritesUiState.Loading)
        private set

    init {
        getMoreMedias(1)
    }

    override fun getMoreMedias(page: Int) {
        viewModelScope.launch {
            getFavoritesUiState = try {
                val resultFavoritesMovie = RetrofitService.retrofitService.getFavoritesMovie(page)
                val resultFavoritesSeries = RetrofitService.retrofitService.getFavoritesSeries(page)

                val result = resultFavoritesMovie.results + resultFavoritesSeries.results
                val sorted = result.sortedBy { it.voteAverage }

                defaultListResponse = defaultListResponse + sorted

                GetFavoritesUiState.Success(defaultListResponse)
            } catch (e: IOException) {
                GetFavoritesUiState.Error
            } catch (e: HttpException) {
                GetFavoritesUiState.Error
            }
        }
    }

    fun addFavorites(mediaId: String, mediaType: String) {
        viewModelScope.launch {
            _status.value = RequestStatus.LOADING

            addFavoritesUiState = try {
                val body = FavoriteBody(
                    true,
                    mediaId,
                    mediaType
                )

                val result = RetrofitService.retrofitService.addFavorites(body)

                _status.value = RequestStatus.SUCCESS

                AddFavoritesUiState.Success(result)
            } catch (e: IOException) {
                _status.value = RequestStatus.FAILURE
                AddFavoritesUiState.Error

            } catch (e: HttpException) {
                _status.value = RequestStatus.FAILURE
                AddFavoritesUiState.Error

            }
        }
    }

    override fun removeFavorites(mediaId: String, mediaType: String) {
        viewModelScope.launch {
            addFavoritesUiState = try {
                val body = FavoriteBody(
                    false,
                    mediaId,
                    mediaType
                )

                val result = RetrofitService.retrofitService.removeFavorites(body)
                AddFavoritesUiState.Success(result)
            } catch (e: IOException) {
                AddFavoritesUiState.Error
            } catch (e: HttpException) {
                AddFavoritesUiState.Error
            }
        }
    }
}