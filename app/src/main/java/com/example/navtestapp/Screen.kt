package com.example.navtestapp

sealed class Screen(val route: String) {

    object LoginScreen: Screen("Login")
    object SignUpScreen: Screen("SignUp")
    object FriendsListScreen: Screen("FriendsList")
    object ProfileScreen: Screen("Profile")

}