package com.example.navtestapp.features.home.friendsList

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navtestapp.Screen

fun NavGraphBuilder.friendsListScreenNavigation(
    navController: NavController
) {
    composable(
        route = Screen.FriendsListScreen.route + "/{email}",
        arguments = listOf(
            navArgument("email") {
                nullable = true
                defaultValue = "Jihad@gmail.com"
                type = NavType.StringType
            }
        )
    ) {entry ->
        FriendsList(navController = navController, entry.arguments?.getString("email"))
    }
}