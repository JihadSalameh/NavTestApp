package com.example.navtestapp.ui.features.auth.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navtestapp.ui.features.Screen

fun NavGraphBuilder.signupScreenNavigation(
    goToLoginScreen: () -> Unit,
    goToFriendsListScreen: (String) -> Unit
) {
    composable(
        route = Screen.SignUpScreen.route
    ) {
        SignUp(
            goToLoginScreen = goToLoginScreen,
            goToFriendsListScreen = goToFriendsListScreen
        )
    }
}