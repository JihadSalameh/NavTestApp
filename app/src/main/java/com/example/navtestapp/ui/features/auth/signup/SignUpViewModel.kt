package com.example.navtestapp.ui.features.auth.signup

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    private var _selectedTabIndex = mutableIntStateOf(0)
    var selectedTabIndex = _selectedTabIndex.asIntState()
    private var _isError = mutableStateOf(false)

    fun updateTabIndex(index: Int) {
        _selectedTabIndex.intValue = index
    }

    fun isSelected(index: Int): Boolean {
        return _selectedTabIndex.intValue == index
    }

    fun getIsError(): Boolean {
        return _isError.value
    }

    fun validateCredentials(email: String) {
        _isError.value = selectedTabIndex.intValue == 0 && !email.contains("@")
    }
}