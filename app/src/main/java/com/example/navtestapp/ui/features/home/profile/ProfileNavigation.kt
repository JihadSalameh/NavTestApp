package com.example.navtestapp.ui.features.home.profile

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navtestapp.UserViewModel
import com.example.navtestapp.ui.features.Screen

fun NavGraphBuilder.profileScreenNavigation(
    goToFriendsListScreen: () -> Unit,
) {
    composable(
        route = Screen.ProfileScreen.route + "/{name}",
        arguments = listOf(
            navArgument("name") {
                nullable = false
                type = NavType.IntType
            }
        ),
        enterTransition = {
            return@composable slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
            )
        },
        exitTransition = {
            return@composable slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(500)
            )
        }
    ) {entry ->
        Profile(
            goToFriendsListScreen = goToFriendsListScreen,
            entry.arguments?.getInt("name")
        )
    }
}