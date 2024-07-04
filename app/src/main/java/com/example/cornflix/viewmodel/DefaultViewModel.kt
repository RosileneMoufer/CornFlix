package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cornflix.constants.RequestStatus
import com.example.cornflix.model.media.MediaModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class DefaultViewModel : ViewModel() {
    open val mediaType : String = "movie"
    var defaultListResponse : List<MediaModel> by  mutableStateOf(listOf())

    open var trailerState: TrailerIdState by mutableStateOf(TrailerIdState.IsNull)

    open fun getMoreMedias(page: Int) {}
    open fun removeFavorites(mediaId: String, mediaType: String) {}
}