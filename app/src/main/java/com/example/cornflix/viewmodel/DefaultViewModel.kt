package com.example.cornflix.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cornflix.model.media.MediaModel


abstract class DefaultViewModel() : ViewModel() {
    open val mediaType: String = "movie"
    var defaultListResponse: List<MediaModel> by mutableStateOf(listOf()) //nao mudar

    open fun getMoreMedias(page: Int) {}
    open fun removeFavorites(mediaId: String, mediaType: String) {}

    //TESTANDO REMOVE DA LAZY
    private val _filteredList = MutableLiveData(listOf<MediaModel>())
    val filteredList: LiveData<List<MediaModel>> = _filteredList

    fun removeFromFilteredList(mediaModel: MediaModel) {
        val currentList = _filteredList.value ?: emptyList()
        val filtered = currentList.filter { it != mediaModel }
        _filteredList.postValue(filtered) // Use postValue for background thread updates
    }

    // Update filteredList based on data source changes (optional)
    fun updateFilteredList(newList: List<MediaModel>) {
        val filteredListValue = _filteredList.value ?: emptyList()
        val filtered = newList.filter { it.id !in filteredListValue.map { it.id } }
        _filteredList.postValue(filtered)
    }


}
// fun exibir filme