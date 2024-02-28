package com.example.navtestapp.ui.features.auth.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navtestapp.ui.features.Screen

fun NavGraphBuilder.loginScreenNavigation(
    goToSignUpScreen: () -> Unit,
    goToFriendsListScreen: (String) -> Unit
){
    composable(
        route = Screen.LoginScreen.route
    ){
        Login(
            goToSignUpScreen = goToSignUpScreen,
            goToFriendsListScreen = goToFriendsListScreen
        )
    }
}