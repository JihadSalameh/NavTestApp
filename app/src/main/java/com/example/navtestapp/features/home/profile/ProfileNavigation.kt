package com.example.navtestapp.features.home.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navtestapp.Screen

fun NavGraphBuilder.profileScreenNavigation(
    navController: NavController
) {
    composable(
        route = Screen.ProfileScreen.route
    ) {
        Profile(navController = navController)
    }
}