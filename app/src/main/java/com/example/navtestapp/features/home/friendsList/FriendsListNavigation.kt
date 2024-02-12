package com.example.navtestapp.features.home.friendsList

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navtestapp.Screen

fun NavGraphBuilder.friendsListScreenNavigation(navController: NavController) {
    composable(
        route = Screen.FriendsListScreen.route
    ) {
        FriendsList(navController = navController)
    }
}