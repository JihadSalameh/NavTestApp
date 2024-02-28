package com.example.navtestapp.ui.features.home.friendsList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.navtestapp.data.Datasource
import com.example.navtestapp.model.User

@Composable
fun FriendsList(
    goToLoginScreen: () -> Unit,
    goToProfileScreen: (User) -> Unit,
    name: String?,
    userViewModel: FriendsListViewModel = hiltViewModel()
) {
    FriendsListScreen(
        goToLoginScreen = goToLoginScreen,
        goToProfileScreen = goToProfileScreen,
        name = name,
        userViewModel = userViewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendsListScreen(
    goToLoginScreen: () -> Unit,
    goToProfileScreen: (User) -> Unit,
    name: String?,
    userViewModel: FriendsListViewModel
) {
    var viewAlert by remember {
        mutableStateOf(false)
    }
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scaffoldState = rememberBottomSheetScaffoldState()

    if(viewAlert) {
        AlertDialogComponent(
            title = "Share Profile",
            body = "share your profile with other users to become friends",
            onDismiss = {
                viewAlert = false
            }
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = { DrawerContentComponent() },
            gesturesEnabled = true
        ) {
            Scaffold(
                snackbarHost = {
                    SnackbarHost(hostState = scaffoldState.snackbarHostState)
                },
                topBar = { TopBarComponent(drawerState = drawerState) },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            viewAlert = true
                        },
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
                    ProfileComponent(
                        goToLoginScreen = goToLoginScreen,
                        name = name
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Divider(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.onBackground)
                    UserList(
                        userViewModel = userViewModel,
                        goToProfileScreen = goToProfileScreen,
                        scaffoldState = scaffoldState
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FriendsListScreenPreview() {
    FriendsListScreen(
        goToLoginScreen = {},
        goToProfileScreen = {},
        name = "",
        userViewModel = FriendsListViewModel(Datasource())
    )
}