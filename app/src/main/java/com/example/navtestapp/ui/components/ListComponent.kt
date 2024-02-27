package com.example.navtestapp.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navtestapp.R
import com.example.navtestapp.ui.features.home.friendsList.FriendsListViewModel
import com.example.navtestapp.model.User
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CardComponent(
    user: User,
    goToProfileScreen: (User) -> Unit
) {
    ListItem(
        modifier = Modifier
            .fillMaxWidth()
            .size(70.dp)
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
                    .size(70.dp)
                    .clip(CircleShape),
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface,
            headlineColor = MaterialTheme.colorScheme.onSurface,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserList(
    goToProfileScreen: (User) -> Unit,
    userViewModel: FriendsListViewModel,
    scaffoldState: BottomSheetScaffoldState
) {
    LaunchedEffect(Unit) {
        userViewModel.isMessageShown.collectLatest {
            if(it) {
                val result = scaffoldState.snackbarHostState.showSnackbar(
                    message = "Friend Deleted",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Short
                )

                when(result) {
                    SnackbarResult.ActionPerformed -> {
                        Log.d("SNACKBAR", "Snackbar Action")
                    }

                    else -> {}
                }
            }
        }
    }

    LazyColumn {
        items(
            items = userViewModel.users,
            key = { it.stringResourceId }
        ) {user ->
            SwipeToDeleteContainer(
                item = user,
                onSwipe = {
                    userViewModel.removeUser(user)
                    userViewModel.setSnackbarMessage()
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
        user = User(1, imageResourceId = R.drawable.image1, stringResourceId = R.string.user1),
        goToProfileScreen = {}
    )
}