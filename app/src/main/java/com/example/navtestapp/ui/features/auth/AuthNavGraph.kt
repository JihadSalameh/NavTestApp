package com.example.navtestapp.ui.features.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.navtestapp.ui.features.Screen
import com.example.navtestapp.ui.features.auth.login.loginScreenNavigation
import com.example.navtestapp.ui.features.auth.signup.signupScreenNavigation

const val AUTH_NAV_GRAPH_ROUTE = "authentication_navigation_graph_route"

fun NavGraphBuilder.authNavGraph(
    navController: NavController
){
    navigation(
        startDestination = Screen.LoginScreen.route,
        route = AUTH_NAV_GRAPH_ROUTE
    ) {
        loginScreenNavigation(
            goToSignUpScreen = {
                navController.navigate(Screen.SignUpScreen.route)
            },
            goToFriendsListScreen = {email ->
                navController.navigate(Screen.FriendsListScreen.route + "?email=$email") {
                    popUpTo(AUTH_NAV_GRAPH_ROUTE) {
                        inclusive = true
                    }
                }
            }
        )
        signupScreenNavigation(
            goToFriendsListScreen = {email ->
                navController.navigate(Screen.FriendsListScreen.route + "?email=$email") {
                    popUpTo(AUTH_NAV_GRAPH_ROUTE) {
                        inclusive = true
                    }
                }
            },
            goToLoginScreen = {
                navController.popBackStack()
            }
        )
    }
}
