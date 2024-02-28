package com.example.navtestapp.ui.features.auth.signup

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navtestapp.ui.components.AuthButton
import com.example.navtestapp.ui.components.AuthTextField
import com.example.navtestapp.ui.components.PasswordTextField
import com.example.navtestapp.ui.components.PhoneNumberTextField

@Composable
fun SignUpFormComponent(
    signUpViewModel: SignUpViewModel,
    goToFriendsListScreen: (String) -> Unit
) {
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }

    if(signUpViewModel.selectedTabIndex.intValue == 0) {
        AuthTextField(
            val1 = username,
            change = {temp ->
                username = temp
            },
            placeHolder = "Username",
            imageVector = Icons.Default.Person
        )
        Spacer(modifier = Modifier.padding(10.dp))
        AuthTextField(
            val1 = email,
            change = {temp ->
                email = temp
            },
            placeHolder = "Email",
            imageVector = Icons.Default.Email,
            isError = signUpViewModel.getIsError()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordTextField(
            val1 = password,
            change = {temp ->
                password = temp
            },
            placeHolder = "Password",
            imageVector = Icons.Default.Lock
        )
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordTextField(
            val1 = confirmPassword,
            change = {temp ->
                confirmPassword = temp
            },
            placeHolder = "Confirm Password",
            imageVector = Icons.Default.Lock
        )
    } else {
        PhoneNumberTextField(
            val1 = phoneNumber,
            change = { temp ->
                phoneNumber = temp
            },
            placeHolder = "Phone Number",
            imageVector = Icons.Default.Phone
        )
    }
    Spacer(modifier = Modifier.padding(10.dp))
    AuthButton(
        change = {
            signUpViewModel.validateCredentials(email)
            if(!signUpViewModel.getIsError()) {
                goToFriendsListScreen(email)
            }
        },
        lbl = "Signup"
    )
}