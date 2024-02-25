package com.example.navtestapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navtestapp.R
import com.example.navtestapp.model.User

@Composable
fun CardComponent(
    user: User,
    goToProfileScreen: (User) -> Unit
) {
    ListItem(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { goToProfileScreen(user) },
        headlineContent = {
            Text(
                text = stringResource(user.stringResourceId),
                style = MaterialTheme.typography.displayMedium,
                fontSize = 40.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        leadingContent = {
            Image(
                painter = painterResource(user.imageResourceId),
                contentDescription = stringResource(user.stringResourceId),
                modifier = Modifier
                    .padding(8.dp)
                    .size(100.dp)
                    .clip(CircleShape),
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface,
            headlineColor = MaterialTheme.colorScheme.onSurface,

        )
    )
}

@Composable
fun UserList(
    users: MutableList<User>,
    goToProfileScreen: (User) -> Unit
) {
    LazyColumn {
        items(
            items = users,
            key = { it.stringResourceId }
        ) {user ->
            SwipeToDeleteContainer(
                item = user,
                onSwipe = {
                    users -= user
                }
            ) { user1 ->
                CardComponent(
                    user = user1,
                    goToProfileScreen = goToProfileScreen
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CardComponentPreview() {
    CardComponent(
        user = User(imageResourceId = R.drawable.image1, stringResourceId = R.string.user1),
        goToProfileScreen = {}
    )
}