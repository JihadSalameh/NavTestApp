package com.example.navtestapp.ui.features.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.navtestapp.ui.components.HeaderTextComponent
import com.example.navtestapp.ui.components.TabComponent
import com.example.navtestapp.ui.components.TabRowComponent

@Composable
fun Login(
    goToFriendsListScreen: (String) -> Unit,
    goToSignUpScreen: () -> Unit,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val uiModel by loginViewModel.uiModel.collectAsStateWithLifecycle()

    EventHandler(loginViewModel.uiEvents) {
        when(it) {
            LoginUiEvents.Error -> { loginViewModel.setIsError() }
            LoginUiEvents.Success -> { goToFriendsListScreen(uiModel.email) }
        }
    }    
    
    LoginScreen(
        goToSignUpScreen = goToSignUpScreen,
        loginViewModel = loginViewModel,
        uiModel = uiModel
    )
}

@Composable
fun LoginScreen(
    goToSignUpScreen: () -> Unit,
    loginViewModel: LoginViewModel,
    uiModel: LoginUiModel
) {
    val tiles = listOf("Email Address", "Phone Number")
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) { values ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeaderTextComponent(name = "Login")
            Spacer(modifier = Modifier.padding(10.dp))
            TabRowComponent(
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                selectedTabIndex = loginViewModel.selectedTabIndex.intValue
            ) {
                tiles.forEachIndexed { index, title ->
                    TabComponent(
                        selected = loginViewModel.isSelected(index),
                        onClick = { loginViewModel.updateTabIndex(index) },
                        text = {
                            if(loginViewModel.isSelected(index)) {
                                Text(text = title, color = MaterialTheme.colorScheme.primary)
                            } else {
                                Text(text = title, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            LoginForm(
                loginViewModel = loginViewModel,
                uiModel = uiModel
            )
            Spacer(modifier = Modifier.padding(10.dp))
            LoginFooterComponent(
                loginViewModel = loginViewModel,
                goToSignUpScreen = goToSignUpScreen
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    Login(
        goToFriendsListScreen = {},
        goToSignUpScreen = {}
    )
}