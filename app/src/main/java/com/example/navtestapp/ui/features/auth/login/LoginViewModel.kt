package com.example.navtestapp.ui.features.auth.login

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel() {
    private var email: String = ""
    private var password: String = ""
    private var phoneNumber: String = ""

    private var _selectedTabIndex = mutableIntStateOf(0)
    var selectedTabIndex = _selectedTabIndex.asIntState()

    private var _isError = mutableStateOf(false)

    private val _uiModel: MutableStateFlow<LoginUiModel> = MutableStateFlow(
        value = LoginUiModel.initialValue()
    )
    val uiModel = _uiModel.asStateFlow()

    private val _uiEvents = mutableEventQueue<LoginUiEvents>()
    val uiEvents: EventQueue<LoginUiEvents> = _uiEvents

    private fun notifyUiState() {
        _uiModel.value = LoginUiModel(
            email = email,
            password = password,
            phoneNumber = phoneNumber
        )
    }

    fun onEmailChanged(email: String) {
        this.email = email
        notifyUiState()
    }

    fun onPasswordChanged(password: String) {
        this.password = password
        notifyUiState()
    }

    fun onPhoneNumberChanged(phoneNumber: String) {
        this.phoneNumber = phoneNumber
        notifyUiState()
    }

    fun updateTabIndex(index: Int) {
        _selectedTabIndex.intValue = index
    }

    fun isSelected(index: Int): Boolean {
        return _selectedTabIndex.intValue == index
    }

    fun getIsError() = _isError.value

    fun setIsError() {
        _isError.value = true
    }

    fun onLoginClicked() {
        login(
            selectedTabIndex = selectedTabIndex.intValue,
            email = email,
            onEvent = _uiEvents::push
        )
    }
}