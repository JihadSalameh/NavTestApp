package com.example.navtestapp.features.home.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navtestapp.Screen

fun NavGraphBuilder.profileScreenNavigation(
    navController: NavController
) {
    composable(
        route = Screen.ProfileScreen.route + "/{name}",
        arguments = listOf(
            navArgument("name") {
                nullable = false
                type = NavType.IntType
            }
        )
    ) {entry ->
        Profile(navController = navController, entry.arguments?.getInt("name"))
    }
}