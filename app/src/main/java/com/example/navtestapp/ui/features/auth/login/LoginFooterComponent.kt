package com.example.navtestapp.ui.features.auth.login

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginFooterComponent(
    loginViewModel: LoginViewModel,
    goToSignUpScreen: () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Don't have an account? ", fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground)
        TextButton(
            onClick = goToSignUpScreen
        ) {
            Text(
                text = "Sign Up",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
    if(loginViewModel.selectedTabIndex.intValue == 0) {
        Spacer(modifier = Modifier.padding(10.dp))
        TextButton(onClick = {  }) {
            Text(
                text = "Forgot Password?",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}