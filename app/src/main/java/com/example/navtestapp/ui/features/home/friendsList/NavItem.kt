package com.example.navtestapp.ui.features.home.friendsList

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean
)
