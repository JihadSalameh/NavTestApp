package com.example.navtestapp.ui.features.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.navtestapp.ui.components.HeaderTextComponent
import com.example.navtestapp.ui.components.TabComponent
import com.example.navtestapp.ui.components.TabRowComponent

@Composable
fun SignUp(
    goToLoginScreen: () -> Unit,
    goToFriendsListScreen: (String) -> Unit,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {
    SignUpScreen(
        goToLoginScreen = goToLoginScreen,
        goToFriendsListScreen = goToFriendsListScreen,
        signUpViewModel = signUpViewModel
    )
}

@Composable
fun SignUpScreen(
    goToLoginScreen: () -> Unit,
    goToFriendsListScreen: (String) -> Unit,
    signUpViewModel: SignUpViewModel
) {
    val tiles = listOf("Email Address", "Phone Number")

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {values ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            HeaderTextComponent(name = "Signup")
            Spacer(modifier = Modifier.padding(10.dp))
            TabRowComponent(
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                selectedTabIndex = signUpViewModel.selectedTabIndex.intValue
            ) {
                tiles.forEachIndexed {index, title ->
                    TabComponent(
                        selected = signUpViewModel.isSelected(index),
                        onClick = { signUpViewModel.updateTabIndex(index) },
                        text = {
                            if(signUpViewModel.isSelected(index)) {
                                Text(text = title, color = MaterialTheme.colorScheme.primary)
                            } else {
                                Text(text = title, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            SignUpFormComponent(
                signUpViewModel = signUpViewModel,
                goToFriendsListScreen = goToFriendsListScreen
            )
            Spacer(modifier = Modifier.padding(10.dp))
            SignUpFooterComponent(goToLoginScreen = goToLoginScreen)
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUp(
        goToLoginScreen = {},
        goToFriendsListScreen = {},
    )
}