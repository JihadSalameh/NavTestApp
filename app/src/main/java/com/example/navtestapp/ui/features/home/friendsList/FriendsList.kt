package com.example.navtestapp.ui.features.home.friendsList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navtestapp.R
import com.example.navtestapp.data.Datasource
import com.example.navtestapp.ui.components.AppButton
import com.example.navtestapp.ui.components.HeaderTextComponent
import com.example.navtestapp.ui.components.UserList
import com.example.navtestapp.ui.features.Screen

const val HOME_NAV_GRAPH_ROUTE = "home_navigation_graph_route"

@Composable
fun FriendsList(
    navController: NavController,
    name: String?
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {  },
                    modifier = Modifier
                        .clip(CircleShape),
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                    )
                }
            }
        ) { values ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(values),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HeaderTextComponent(name = "Friends List")
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.End)
                            .padding(0.dp, 10.dp, 0.dp, 0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Profile", color = MaterialTheme.colorScheme.onBackground)
                        Spacer(modifier = Modifier.padding(10.dp))
                        Image(
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.profilepic),
                            contentDescription = "Profile Picture",
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = "Hello, $name", color = MaterialTheme.colorScheme.onBackground)
                    }
                    AppButton(
                        change = {
                            navController.navigate(Screen.LoginScreen.route) {
                                popUpTo(HOME_NAV_GRAPH_ROUTE) {
                                    inclusive = true
                                }
                            }
                        },
                        lbl = "logout"
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Divider(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.onBackground)
                UserList(users = Datasource().loadUsers(), navController = navController)
            }
        }
    }
}