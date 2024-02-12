package com.example.navtestapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.navtestapp.features.auth.login.loginScreenNavigation
import com.example.navtestapp.features.auth.signup.signupScreenNavigation
import com.example.navtestapp.features.home.friendsList.friendsListScreenNavigation
import com.example.navtestapp.features.home.profile.profileScreenNavigation
import com.example.navtestapp.ui.theme.AUTH_NAV_GRAPH_ROUTE
import com.example.navtestapp.ui.theme.HOME_NAV_GRAPH_ROUTE

@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AUTH_NAV_GRAPH_ROUTE) {
        navigation(
            startDestination = Screen.LoginScreen.route,
            route = AUTH_NAV_GRAPH_ROUTE
        ) {
            loginScreenNavigation(navController)
            signupScreenNavigation(navController)
        }
        navigation(
            startDestination = Screen.FriendsListScreen.route,
            route = HOME_NAV_GRAPH_ROUTE
        ) {
            friendsListScreenNavigation(navController)
            profileScreenNavigation(navController)
        }
    }
}