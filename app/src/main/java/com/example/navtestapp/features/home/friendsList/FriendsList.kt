package com.example.navtestapp.features.home.friendsList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navtestapp.R
import com.example.navtestapp.Screen
import com.example.navtestapp.components.UserList
import com.example.navtestapp.data.Datasource

const val HOME_NAV_GRAPH_ROUTE = "home_navigation_graph_route"

@Composable
fun FriendsList(
    navController: NavController,
    name: String?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            text = "Friends List",
            fontSize = 26.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
                .padding(0.dp, 10.dp, 0.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Profile", color = Color.White)
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "Profile Picture",
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "Hello, $name", color = Color.White)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Red)
        UserList(users = Datasource().loadUsers(), navController = navController)
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = {
                navController.navigate(Screen.LoginScreen.route) {
                    popUpTo(HOME_NAV_GRAPH_ROUTE) {
                        inclusive = true
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier
                .clip(shape = RectangleShape)
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        ) {
            Text(text = "logout")
        }
    }
}