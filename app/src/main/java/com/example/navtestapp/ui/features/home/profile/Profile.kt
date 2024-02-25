package com.example.navtestapp.ui.features.home.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.navtestapp.ui.components.AppButton
import com.example.navtestapp.ui.components.HeaderTextComponent

@Composable
fun Profile(
    goToFriendsListScreen: () -> Unit,
    name: Int?
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeaderTextComponent(name = "Profile")
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = stringResource(id = name!!), color = MaterialTheme.colorScheme.onBackground)
            Spacer(modifier = Modifier.padding(10.dp))
            AppButton(
                change = goToFriendsListScreen,
                lbl = "Back"
            )
        }
    }
}