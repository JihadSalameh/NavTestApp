package com.example.navtestapp.ui.features.auth.signup

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun SignUpFooterComponent(
    goToLoginScreen: () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Already have an account? ",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        TextButton(
            onClick = goToLoginScreen
        ) {
            Text(
                text = "Login",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}