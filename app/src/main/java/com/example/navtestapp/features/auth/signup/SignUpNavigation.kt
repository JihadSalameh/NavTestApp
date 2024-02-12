package com.example.navtestapp.features.auth.signup

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navtestapp.Screen

fun NavGraphBuilder.signupScreenNavigation(navController: NavController) {
    composable(
        route = Screen.SignUpScreen.route
    ) {
        SignUp(navController = navController)
    }
}