package com.example.navtestapp.ui.features.home.friendsList

import android.util.Log
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navtestapp.R
import com.example.navtestapp.data.Datasource
import com.example.navtestapp.ui.components.AlertDialogComponent
import com.example.navtestapp.ui.components.AppButton
import com.example.navtestapp.ui.components.HeaderTextComponent
import com.example.navtestapp.ui.components.UserList
import com.example.navtestapp.ui.features.Screen
import kotlinx.coroutines.launch

const val HOME_NAV_GRAPH_ROUTE = "home_navigation_graph_route"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendsList(
    navController: NavController,
    name: String?
) {
    val temp = remember {
        Datasource().loadUsers().toMutableStateList()
    }
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
                    HeaderTextComponent(name = "NavTestApp")
                    NavigationDrawerItem(
                        label = { Text(text = "Profile") },
                        selected = selectedNavItemIndex == 0,
                        onClick = {
                            selectedNavItemIndex = 0
                            Log.d("profile", "This is your profile")
                        },
                        icon = {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "Settings") },
                        selected = selectedNavItemIndex == 1,
                        onClick = {
                            selectedNavItemIndex = 1
                            Log.d("Settings", "This is the Settings")
                        },
                        icon = {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                        }
                    )
                    NavigationDrawerItem(
                        label = { Text(text = "About Us") },
                        selected = selectedNavItemIndex == 2,
                        onClick = {
                            selectedNavItemIndex = 2
                            Log.d("About Us", "This is About Us")
                        },
                        icon = {
                            Icon(imageVector = Icons.Default.Info, contentDescription = null)
                        }
                    )
                }
            },
            gesturesEnabled = true
        ) {
            Scaffold(
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
                    UserList(users = temp, navController = navController)
                }
            }
        }
    }
}