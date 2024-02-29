package com.example.navtestapp.ui.features.auth.signup

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel: ViewModel() {
    private var username: String = ""
    private var email: String = ""
    private var password: String = ""
    private var confirmPassword: String = ""
    private var phoneNumber: String = ""

    private var _selectedTabIndex = mutableIntStateOf(0)
    var selectedTabIndex = _selectedTabIndex.asIntState()
    private var _isError = mutableStateOf(false)

    private val _uiModel: MutableStateFlow<SignUpUiModel> = MutableStateFlow(
        value = SignUpUiModel.initialValue()
    )
    val uiModel = _uiModel.asStateFlow()

    private fun notifyUiState() {
        _uiModel.value = SignUpUiModel(
            username = username,
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            phoneNumber = phoneNumber
        )
    }

    fun onUsernameChange(username: String) {
        this.username = username
        notifyUiState()
    }

    fun onEmailChange(email: String) {
        this.email = email
        notifyUiState()
    }

    fun onPasswordChange(password: String) {
        this.password = password
        notifyUiState()
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        this.confirmPassword = confirmPassword
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

    fun getIsError(): Boolean {
        return _isError.value
    }

    fun validateCredentials(email: String) {
        _isError.value = selectedTabIndex.intValue == 0 && !email.contains("@")
    }
}