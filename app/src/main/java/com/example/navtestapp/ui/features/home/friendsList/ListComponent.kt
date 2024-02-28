package com.example.navtestapp.ui.features.home.friendsList

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navtestapp.R
import com.example.navtestapp.model.User
import kotlinx.coroutines.delay
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SwipeToDeleteContainer(
    item: T,
    animationDuration: Int = 500,
    onSwipe: (T) -> Unit,
    content: @Composable (T) -> Unit
) {
    var isRemoved by remember {
        mutableStateOf(false)
    }
    val state = rememberDismissState(
        confirmValueChange = {value ->
            if(value == DismissValue.DismissedToStart) {
                isRemoved = true
                true
            } else {
                false
            }
        }
    )

    LaunchedEffect(key1 = isRemoved) {
        if(isRemoved) {
            delay(animationDuration.toLong())
            onSwipe(item)
        }
    }

    AnimatedVisibility(
        visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration),
            shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismiss(
            state = state,
            background = {
                DeleteBackground(swipeDismissState = state)
            },
            dismissContent = { content(item) },
            directions = setOf(DismissDirection.EndToStart)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteBackground(
    swipeDismissState: DismissState
) {
    val color = if(swipeDismissState.dismissDirection == DismissDirection.EndToStart) {
        Color.Red
    } else {
        Color.Transparent
    }

    ListItem(
        headlineContent = {},
        colors = ListItemDefaults.colors(containerColor = color),
        trailingContent = {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = Color.White,
            )
        },
        modifier = Modifier.fillMaxSize()
    )
}