package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.api.RetrofitService
import com.example.cornflix.constants.RequestStatus
import com.example.cornflix.model.media.MediaModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface TrailerIdState {
    data class IsNotNull(val mediaKey: String) : TrailerIdState
    data object IsNull : TrailerIdState
}

class TrailerViewModel : ViewModel() {
    var trailerState: TrailerIdState by mutableStateOf(TrailerIdState.IsNull)
    var trailerKey: String by mutableStateOf("")

    val _status = MutableStateFlow(RequestStatus.LOADING)
    val status : StateFlow<RequestStatus> = _status

    fun getTrailer(mediaId: String, mediaType: String) {
        viewModelScope.launch {
            trailerState = try {
                val videos =
                    if (mediaType == "movie") RetrofitService.retrofitService.getTrailerMovie(
                        mediaId
                    )
                    else RetrofitService.retrofitService.getTrailerSeries(mediaId)

                var trailers = videos.results.filter { it.type == "Trailer" }
                if (trailers.isEmpty()) {
                    trailers = videos.results.filter { it.type == "Teaser" }
                }
                trailerKey = trailers[0].key

                _status.value = RequestStatus.SUCCESS

                TrailerIdState.IsNotNull(trailers[0].key)
            } catch (e: IOException) {
                //e.message?.let { Log.e("", it) }
                _status.value = RequestStatus.FAILURE
                TrailerIdState.IsNull
            } catch (e: HttpException) {
                //e.message?.let { Log.e("", it) }
                TrailerIdState.IsNull
            } catch (e: IndexOutOfBoundsException) {
                //e.message?.let { Log.e("", it) }
                _status.value = RequestStatus.FAILURE
                TrailerIdState.IsNull
            }
        }

    }
}