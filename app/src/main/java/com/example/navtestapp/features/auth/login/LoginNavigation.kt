package com.example.navtestapp.features.auth.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navtestapp.Screen

fun NavGraphBuilder.loginScreenNavigation(navController: NavController){
    composable(
        route = Screen.LoginScreen.route
    ){
        Login(navController = navController)
    }
}