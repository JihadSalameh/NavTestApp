package com.example.navtestapp.ui.features

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navtestapp.ui.features.auth.authNavGraph
import com.example.navtestapp.ui.features.home.homeNavGraph

const val AUTH_NAV_GRAPH_ROUTE = "authentication_navigation_graph_route"

@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AUTH_NAV_GRAPH_ROUTE
    ) {
        authNavGraph(navController)
        homeNavGraph(navController)
    }
}