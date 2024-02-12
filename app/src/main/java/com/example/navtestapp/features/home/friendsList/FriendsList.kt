package com.example.navtestapp.features.home.friendsList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.navtestapp.Screen

@Composable
fun FriendsList(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Friends List Page")
        Button(onClick = { navController.navigate(Screen.ProfileScreen.route) }) {
            Text(text = "View First Friend Profile")
        }
        Button(onClick = { navController.navigate(Screen.LoginScreen.route) }) {
            Text(text = "logout")
        }
    }
}