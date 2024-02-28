package com.example.navtestapp.ui.features.home.friendsList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.navtestapp.R
import com.example.navtestapp.ui.components.AppButton

@Composable
fun ProfileComponent(
    goToLoginScreen: () -> Unit,
    name: String?
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
}