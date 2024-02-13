package com.example.navtestapp.features.auth.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navtestapp.Screen

@Composable
fun Login(navController: NavController) {
    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            text = "Login",
            fontSize = 26.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TextField(
            value = text1,
            onValueChange = {temp ->
                text1 = temp
            },
            Modifier
                .clip(shape = RectangleShape)
                .fillMaxWidth()
                .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
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
            Modifier
                .clip(shape = RectangleShape)
                .fillMaxWidth()
                .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
            placeholder = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { navController.navigate(Screen.FriendsListScreen.routeWithArgs(text1)) },
            modifier = Modifier
                .clip(shape = RectangleShape)
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = "Login", fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't have an account? ", fontSize = 14.sp, color = Color.White)
            Text(
                text = "Sign Up",
                Modifier.clickable {
                    navController.navigate(Screen.SignUpScreen.route)
                },
                color = Color.Red,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Forgot Password?",
            Modifier
                .clickable {
                    Log.d("test", "Hello World")
                },
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}