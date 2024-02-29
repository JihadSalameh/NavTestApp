package com.example.navtestapp.ui.features.auth.login

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navtestapp.ui.components.AuthButton
import com.example.navtestapp.ui.components.AuthTextField
import com.example.navtestapp.ui.components.PasswordTextField
import com.example.navtestapp.ui.components.PhoneNumberTextField

@Composable
fun LoginForm(
    loginViewModel: LoginViewModel,
    goToFriendsListScreen: (String) -> Unit,
    uiModel: LoginUiModel
) {
    if(loginViewModel.selectedTabIndex.intValue == 0) {
        AuthTextField(
            val1 = uiModel.email,
            change = loginViewModel::onEmailChanged,
            placeHolder = "Email",
            imageVector = Icons.Default.Email,
            isError = loginViewModel.getIsError()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordTextField(
            val1 = uiModel.password,
            change = loginViewModel::onPasswordChanged,
            placeHolder = "Password",
            imageVector = Icons.Default.Lock,
        )
    } else {
        PhoneNumberTextField(
            val1 = uiModel.phoneNumber,
            change = loginViewModel::onPhoneNumberChanged,
            placeHolder = "Phone Number",
            imageVector = Icons.Default.Phone
        )
    }
    Spacer(modifier = Modifier.padding(10.dp))
    AuthButton(
        change = {
            loginViewModel.validateCredentials(uiModel.email)
            if(!loginViewModel.getIsError()) {
                goToFriendsListScreen(uiModel.email)
            }
        },
        lbl = "Login"
    )
}