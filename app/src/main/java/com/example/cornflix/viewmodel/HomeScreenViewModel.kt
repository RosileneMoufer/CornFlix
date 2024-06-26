package com.example.cornflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeScreenViewModel: ViewModel(){
    private val _showMenuIcon = MutableLiveData(true)
    val showMenuIcon: LiveData<Boolean> = _showMenuIcon

    private val _expanded = MutableLiveData(false)
    val expanded: LiveData<Boolean> = _expanded

    fun changeIcon(showMi: Boolean, expand: Boolean){
        _showMenuIcon.value = showMi
        _expanded.value = expand
    }

}