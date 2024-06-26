package com.example.cornflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cornflix.constants.ConstantsAPI
import com.example.cornflix.models.MoviesModel
import com.example.cornflix.retrofit_config.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel: ViewModel() {
    private var _nowPlaying = MutableLiveData<List<MoviesModel>>()
    var nowPLaying: LiveData<List<MoviesModel>> = _nowPlaying

    private var _movieList = MutableLiveData<List<MoviesModel>>()
    var movieList: LiveData<List<MoviesModel>> = _movieList

    fun getMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getNowPlaying(ConstantsAPI.API_KEY)

            withContext(Dispatchers.Main) {
                _movieList.value = response.body()!!.results.sortedBy { it.voteAverage }
            }
        }
    }

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getNowPlaying(ConstantsAPI.API_KEY)

            withContext(Dispatchers.Main) {
                _movieList.value = response.body()!!.results.sortedBy { it.voteAverage }
            }
        }
    }
}