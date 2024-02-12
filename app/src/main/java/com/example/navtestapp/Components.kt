package com.example.navtestapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "SignUp")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
    Login()
}

@Composable
fun SignUp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SignUp")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Signup")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp()
}

@Composable
fun FriendsList() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Friends List Page")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "View First Friend Profile")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FriendsListPreview() {
    FriendsList()
}

@Composable
fun Profile() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Page")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Back")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfilePreview() {
    Profile()
}