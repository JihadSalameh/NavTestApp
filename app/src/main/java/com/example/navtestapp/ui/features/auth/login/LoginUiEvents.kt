package com.example.navtestapp.ui.features.auth.login

sealed interface LoginUiEvents {
    data object Success : LoginUiEvents
    data object Error: LoginUiEvents
}

fun login(
    selectedTabIndex: Int,
    email: String,
    onEvent: (LoginUiEvents) -> Unit
) {
    if(selectedTabIndex == 0 && !email.contains("@")) {
        onEvent(LoginUiEvents.Error)
    } else {
        onEvent(LoginUiEvents.Success)
    }
}