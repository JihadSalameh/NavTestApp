package com.example.navtestapp.ui.features.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.navtestapp.ui.features.Screen
import com.example.navtestapp.ui.features.home.friendsList.friendsListScreenNavigation
import com.example.navtestapp.ui.features.home.profile.profileScreenNavigation

const val HOME_NAV_GRAPH_ROUTE = "home_navigation_graph_route"

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.FriendsListScreen.route,
        route = HOME_NAV_GRAPH_ROUTE
    ) {
        friendsListScreenNavigation(
            goToLoginScreen = {
                navController.navigate(Screen.LoginScreen.route) {
                    popUpTo(HOME_NAV_GRAPH_ROUTE) {
                        inclusive = true
                    }
                }
            },
            goToProfileScreen = {user ->
                navController.navigate(Screen.ProfileScreen.route + "/${user.stringResourceId}")
            }
        )
        profileScreenNavigation(
            goToFriendsListScreen = {
                navController.popBackStack()
            }
        )
    }
}