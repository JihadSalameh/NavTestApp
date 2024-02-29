package com.example.navtestapp.ui.features.auth.signup

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navtestapp.ui.components.AuthButton
import com.example.navtestapp.ui.components.AuthTextField
import com.example.navtestapp.ui.components.PasswordTextField
import com.example.navtestapp.ui.components.PhoneNumberTextField

@Composable
fun SignUpFormComponent(
    signUpViewModel: SignUpViewModel,
    goToFriendsListScreen: (String) -> Unit,
    uiModel: SignUpUiModel
) {
    if(signUpViewModel.selectedTabIndex.intValue == 0) {
        AuthTextField(
            val1 = uiModel.username,
            change = signUpViewModel::onUsernameChange,
            placeHolder = "Username",
            imageVector = Icons.Default.Person
        )
        Spacer(modifier = Modifier.padding(10.dp))
        AuthTextField(
            val1 = uiModel.email,
            change = signUpViewModel::onEmailChange,
            placeHolder = "Email",
            imageVector = Icons.Default.Email,
            isError = signUpViewModel.getIsError()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordTextField(
            val1 = uiModel.password,
            change = signUpViewModel::onPasswordChange,
            placeHolder = "Password",
            imageVector = Icons.Default.Lock
        )
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordTextField(
            val1 = uiModel.confirmPassword,
            change = signUpViewModel::onConfirmPasswordChange,
            placeHolder = "Confirm Password",
            imageVector = Icons.Default.Lock
        )
    } else {
        PhoneNumberTextField(
            val1 = uiModel.phoneNumber,
            change = signUpViewModel::onPhoneNumberChanged,
            placeHolder = "Phone Number",
            imageVector = Icons.Default.Phone
        )
    }
    Spacer(modifier = Modifier.padding(10.dp))
    AuthButton(
        change = {
            signUpViewModel.validateCredentials(uiModel.email)
            if(!signUpViewModel.getIsError()) {
                goToFriendsListScreen(uiModel.email)
            }
        },
        lbl = "Signup"
    )
}