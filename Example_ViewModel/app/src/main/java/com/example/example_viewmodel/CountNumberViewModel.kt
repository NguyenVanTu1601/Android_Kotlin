package com.example.example_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountNumberViewModel : ViewModel() {
    var number : Int = 0

    fun addNumber(){
        viewModelScope.launch(Dispatchers.IO) {
            number++
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}