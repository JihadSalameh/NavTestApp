package com.example.navtestapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navtestapp.model.User
import com.example.navtestapp.ui.features.Screen

@Composable
fun CardComponent(user: User, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp, 8.dp, 8.dp, 0.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screen.ProfileScreen.route + "/${user.stringResourceId}")
            },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(user.imageResourceId),
                contentDescription = stringResource(user.stringResourceId),
                modifier = Modifier
                    .padding(8.dp)
                    .size(120.dp)
                    .clip(CircleShape),
            )
            Text(
                text = stringResource(user.stringResourceId),
                modifier = Modifier
                    .padding(10.dp, 40.dp, 0.dp, 0.dp),
                style = MaterialTheme.typography.displayMedium,
                fontSize = 40.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun UserList(users: List<User>, navController: NavController) {
    LazyColumn {
        items(users) {user ->
            CardComponent(user, navController)
        }
    }
}