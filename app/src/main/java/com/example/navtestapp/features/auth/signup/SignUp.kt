package com.example.navtestapp.features.auth.signup

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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navtestapp.R
import com.example.navtestapp.Screen
import com.example.navtestapp.components.TabComponent
import com.example.navtestapp.components.TabRowComponent

@Composable
fun SignUp(
    navController: NavController
) {
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    val tiles = listOf("Email Address", "Phone Number")
    var selectedTab by rememberSaveable {
        mutableIntStateOf(0)
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
            text = "Signup",
            fontSize = 26.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TabRowComponent(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp), selectedTabIndex = selectedTab) {
            tiles.forEachIndexed {index, title ->
                TabComponent(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(text = title)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        if(selectedTab == 0) {
            OutlinedTextField(
                value = username,
                onValueChange = { temp ->
                    username = temp
                },
                Modifier
                    .clip(shape = RectangleShape)
                    .fillMaxWidth()
                    .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
                placeholder = {
                    Text(text = "UserName")
                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_account_circle_24), contentDescription = "UserName")
                },
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { temp ->
                    email = temp
                },
                Modifier
                    .clip(shape = RectangleShape)
                    .fillMaxWidth()
                    .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
                placeholder = {
                    Text(text = "Email")
                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_email_24), contentDescription = "Email")
                },
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {temp ->
                    password = temp
                },
                Modifier
                    .clip(shape = RectangleShape)
                    .fillMaxWidth()
                    .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
                placeholder = {
                    Text(text = "Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_lock_24), contentDescription = "Password")
                },
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {temp ->
                    confirmPassword = temp
                },
                Modifier
                    .clip(shape = RectangleShape)
                    .fillMaxWidth()
                    .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
                placeholder = {
                    Text(text = "Confirm Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_lock_24), contentDescription = "Confirm Password")
                },
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
        } else {
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { temp ->
                    phoneNumber = temp
                },
                Modifier
                    .clip(shape = RectangleShape)
                    .fillMaxWidth()
                    .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
                placeholder = {
                    Text(text = "Phone Number")
                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.baseline_numpad_24), contentDescription = "Phone Number")
                },
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { navController.navigate(Screen.FriendsListScreen.route + "?email=$email") },
            modifier = Modifier
                .clip(shape = RectangleShape)
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = "Signup", fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Already have an account? ", fontSize = 14.sp, color = Color.White)
            Text(
                text = "Login",
                Modifier.clickable {
                    navController.popBackStack()
                },
                color = Color.Red,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}