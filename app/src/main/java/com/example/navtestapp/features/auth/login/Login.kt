package com.example.navtestapp.features.auth.login

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
fun Login(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login")
        Button(onClick = { navController.navigate(Screen.FriendsListScreen.route) }) {
            Text(text = "Login")
        }
        Button(onClick = { navController.navigate(Screen.SignUpScreen.route) }) {
            Text(text = "SignUp")
        }
    }
}