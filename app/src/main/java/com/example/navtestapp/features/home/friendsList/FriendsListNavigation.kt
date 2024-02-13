package com.example.navtestapp.features.home.friendsList

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navtestapp.Screen

fun NavGraphBuilder.friendsListScreenNavigation(navController: NavController) {
    composable(
        route = Screen.FriendsListScreen.route + "/{name}",
        arguments = listOf(
            navArgument("name") {
                nullable = true
                defaultValue = "Jihad"
                type = NavType.StringType
            }
        )
    ) {entry ->
        FriendsList(navController = navController, entry.arguments?.getString("name"))
    }
}