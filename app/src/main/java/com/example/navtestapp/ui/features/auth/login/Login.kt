package com.example.navtestapp.ui.features.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navtestapp.ui.components.AuthButton
import com.example.navtestapp.ui.components.AuthTextField
import com.example.navtestapp.ui.components.HeaderTextComponent
import com.example.navtestapp.ui.components.PasswordTextField
import com.example.navtestapp.ui.components.PhoneNumberTextField
import com.example.navtestapp.ui.components.TabComponent
import com.example.navtestapp.ui.components.TabRowComponent
import com.example.navtestapp.ui.features.Screen

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
            HeaderTextComponent(name = "Login")
            Spacer(modifier = Modifier.padding(10.dp))
            TabRowComponent(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp), selectedTabIndex = selectedTab) {
                tiles.forEachIndexed {index, title ->
                    TabComponent(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            if(selectedTab == index) {
                                Text(text = title, color = MaterialTheme.colorScheme.primary)
                            } else {
                                Text(text = title, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            if(selectedTab == 0) {
                AuthTextField(
                    val1 = email,
                    change = {temp ->
                        email = temp
                    },
                    placeHolder = "Email",
                    imageVector = Icons.Default.Email
                )
                Spacer(modifier = Modifier.padding(10.dp))
                PasswordTextField(
                    val1 = password,
                    change = {temp ->
                        password = temp
                    },
                    placeHolder = "Password",
                    imageVector = Icons.Default.Lock
                )
            } else {
                PhoneNumberTextField(
                    val1 = phoneNumber,
                    change = { temp ->
                        phoneNumber = temp
                    },
                    placeHolder = "Phone Number",
                    imageVector = Icons.Default.Phone
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            AuthButton(
                change = {
                    navController.navigate(Screen.FriendsListScreen.route + "?email=$email") {
                        popUpTo(AUTH_NAV_GRAPH_ROUTE) {
                            inclusive = true
                        }
                    }
                },
                lbl = "Login"
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account? ", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground)
                TextButton(
                    onClick = { navController.navigate(Screen.SignUpScreen.route) }
                ) {
                    Text(
                        text = "Sign Up",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            if(selectedTab == 0) {
                Spacer(modifier = Modifier.padding(10.dp))
                TextButton(onClick = {  }) {
                    Text(
                        text = "Forgot Password?",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}