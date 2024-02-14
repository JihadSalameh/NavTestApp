package com.example.navtestapp.features.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.navtestapp.Screen
import com.example.navtestapp.features.home.friendsList.friendsListScreenNavigation
import com.example.navtestapp.features.home.profile.profileScreenNavigation

const val HOME_NAV_GRAPH_ROUTE = "home_navigation_graph_route"

fun NavGraphBuilder.homeNavGraph(
    navController: NavController
) {
    navigation(
        startDestination = Screen.FriendsListScreen.route,
        route = HOME_NAV_GRAPH_ROUTE
    ) {
        friendsListScreenNavigation(navController)
        profileScreenNavigation(navController)
    }
}