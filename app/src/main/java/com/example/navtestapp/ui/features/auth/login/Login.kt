package com.example.navtestapp.ui.features.auth.login

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navtestapp.R
import com.example.navtestapp.ui.features.Screen
import com.example.navtestapp.ui.components.TabComponent
import com.example.navtestapp.ui.components.TabRowComponent

const val AUTH_NAV_GRAPH_ROUTE = "authentication_navigation_graph_route"

@Composable
fun Login(
    navController: NavController
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var phoneNumber by remember {
        mutableStateOf("")
    }
    val tiles = listOf("Email Address", "Phone Number")
    var selectedTab by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {values ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(values),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                text = "Login",
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.onBackground
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
                    value = email,
                    onValueChange = {temp ->
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
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = MaterialTheme.colorScheme.onBackground, unfocusedTextColor = MaterialTheme.colorScheme.onBackground)
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
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = MaterialTheme.colorScheme.onBackground, unfocusedTextColor = MaterialTheme.colorScheme.onBackground)
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = {
                        Text(text = "Phone Number")
                    },
                    leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.baseline_numpad_24), contentDescription = "Phone Number")
                    },
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = MaterialTheme.colorScheme.onBackground, unfocusedTextColor = MaterialTheme.colorScheme.onBackground)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.FriendsListScreen.route + "?email=$email") {
                        popUpTo(AUTH_NAV_GRAPH_ROUTE) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "Login", fontSize = 25.sp, color = MaterialTheme.colorScheme.onPrimary)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account? ", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground)
                Text(
                    text = "Sign Up",
                    Modifier.clickable {
                        navController.navigate(Screen.SignUpScreen.route)
                    },
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            if(selectedTab == 0) {
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Forgot Password?",
                    Modifier
                        .clickable {
                            Log.d("test", "Hello World")
                        },
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}