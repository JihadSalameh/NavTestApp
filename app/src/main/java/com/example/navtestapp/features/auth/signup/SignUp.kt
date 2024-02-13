package com.example.navtestapp.features.auth.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navtestapp.Screen

@Composable
fun SignUp(navController: NavController) {
    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            text = "Signup Page",
            fontSize = 26.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = text1,
            onValueChange = {temp ->
                text1 = temp
            },
            Modifier.clip(shape = CircleShape),
            placeholder = {
                Text(text = "Name")
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = text2,
            onValueChange = {temp ->
                text2 = temp
            },
            Modifier.clip(shape = CircleShape),
            placeholder = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { navController.navigate(Screen.FriendsListScreen.routeWithArgs(text1)) }) {
            Text(text = "Signup")
        }
    }
}