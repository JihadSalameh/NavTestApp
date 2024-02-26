package com.example.navtestapp.ui.features.home.friendsList

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navtestapp.UserViewModel
import com.example.navtestapp.model.User
import com.example.navtestapp.ui.features.Screen

fun NavGraphBuilder.friendsListScreenNavigation(
    goToLoginScreen: () -> Unit,
    goToProfileScreen: (User) -> Unit,
    userViewModel: UserViewModel
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
        FriendsList(
            goToLoginScreen = goToLoginScreen,
            goToProfileScreen = goToProfileScreen,
            entry.arguments?.getString("email"),
            userViewModel = userViewModel
        )
    }
}