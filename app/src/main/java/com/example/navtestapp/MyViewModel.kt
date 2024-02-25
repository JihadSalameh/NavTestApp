package com.example.navtestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(500)
            _loading.value = false
        }
    }

}