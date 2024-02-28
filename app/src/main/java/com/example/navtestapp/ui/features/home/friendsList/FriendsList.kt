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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.navtestapp.R
import com.example.navtestapp.data.Datasource
import com.example.navtestapp.model.User
import com.example.navtestapp.ui.components.AlertDialogComponent
import com.example.navtestapp.ui.components.AppButton
import com.example.navtestapp.ui.components.HeaderTextComponent
import com.example.navtestapp.ui.components.UserList
import kotlinx.coroutines.launch

data class NavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean
)

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
    val items = listOf(
        NavItem(
            title = "Profile",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
            hasNews = true
        ),
        NavItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false
        ),
        NavItem(
            title = "Info",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            hasNews = false
        )
    )
    var viewAlert by remember {
        mutableStateOf(false)
    }
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()
    var selectedNavItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
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
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .padding(start = 10.dp),
                        text = "NavTestApp",
                        fontSize = 26.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.padding(16.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = { Text(text = item.title) },
                            selected = selectedNavItemIndex == index,
                            onClick = {
                                selectedNavItemIndex = index
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if(item.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if(selectedNavItemIndex == index) {
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
                }
            },
            gesturesEnabled = true
        ) {
            Scaffold(
                snackbarHost = {
                    SnackbarHost(
                        hostState = scaffoldState.snackbarHostState
                    )
                },
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            HeaderTextComponent(name = "Friends List")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = null
                                )
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                            titleContentColor = MaterialTheme.colorScheme.onSurface
                        )
                    )
                },
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
                            change = goToLoginScreen,
                            lbl = "logout"
                        )
                    }
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