package com.example.navtestapp.ui.features.auth.login

class LoginUiModel(
    val email: String,
    val password: String,
    val phoneNumber: String
) {

    companion object {
        fun initialValue() = LoginUiModel(
            email = "",
            password = "",
            phoneNumber = ""
        )

        fun preview() = initialValue()
    }

}