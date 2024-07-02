package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cornflix.model.media.MediaModel


abstract class DefaultViewModel : ViewModel() {
    var defaultListResponse : List<MediaModel> by mutableStateOf(listOf())

    open fun getMoreMedias(page: Int) {}
}