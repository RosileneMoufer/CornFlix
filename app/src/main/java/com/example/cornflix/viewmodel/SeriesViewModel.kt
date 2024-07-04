package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.media.MediaModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface SeriesUiState {
    data class Success(val result: List<MediaModel>) : SeriesUiState
    data object Error : SeriesUiState
    data object Loading : SeriesUiState
}

class SeriesViewModel : DefaultViewModel() {
    override var mediaType = "tv"

    var seriesUiState: SeriesUiState by mutableStateOf(SeriesUiState.Loading)
        private set

    init {
        getMoreMedias(1)
    }

    override fun getMoreMedias(page : Int) {
        viewModelScope.launch {
            seriesUiState = try {
                val result = RetrofitService.retrofitService.getPopularSeries(page)
                defaultListResponse = defaultListResponse + result.results

                SeriesUiState.Success(defaultListResponse)
            } catch (e: IOException) {
                SeriesUiState.Error
            } catch (e: HttpException) {
                SeriesUiState.Error
            }
        }
    }
}