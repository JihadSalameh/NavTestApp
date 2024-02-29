package com.example.navtestapp.ui.features.auth.signup

class SignUpUiModel(
    val username: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val phoneNumber: String,
) {

    companion object {
        fun initialValue() = SignUpUiModel(
            username = "",
            email = "",
            password = "",
            confirmPassword = "",
            phoneNumber = ""
        )

        fun preview() = initialValue()
    }

}