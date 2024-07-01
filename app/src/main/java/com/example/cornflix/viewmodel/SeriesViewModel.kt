package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.model.media.MediaResponse
import com.example.cornflix.model.series.Series
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface SeriesUiState {
    data class Success(val result: MediaResponse<Series>) : SeriesUiState
    data object Error : SeriesUiState
    data object Loading : SeriesUiState
}

class SeriesViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var seriesUiState: SeriesUiState by mutableStateOf(SeriesUiState.Loading)
        private set

    init {
        getSeries()
    }

    private fun getSeries() {
        viewModelScope.launch {
            seriesUiState = SeriesUiState.Loading
            seriesUiState = try {
                val result = RetrofitService.retrofitService.getPopularSeries()
                SeriesUiState.Success(result)
            } catch (e: IOException) {
                SeriesUiState.Error
            } catch (e: HttpException) {
                SeriesUiState.Error
            }
        }
    }
}