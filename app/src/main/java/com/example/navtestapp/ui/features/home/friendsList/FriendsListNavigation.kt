package com.example.navtestapp.ui.features.home.friendsList

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navtestapp.ui.features.Screen

fun NavGraphBuilder.friendsListScreenNavigation(
    navController: NavController
) {
    composable(
        route = Screen.FriendsListScreen.route + "?email={email}",
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