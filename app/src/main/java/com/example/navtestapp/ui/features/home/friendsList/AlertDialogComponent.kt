package com.example.navtestapp.ui.features.home.friendsList

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.navtestapp.ui.components.AppButton

@Composable
fun AlertDialogComponent(
    title: String,
    body: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            AppButton(change = { Log.d("Alert", "test test") }, lbl = "Share")
        },
        icon = {
            Icon(imageVector = Icons.Default.Info, contentDescription = null)
        },
        title = {
            Text(text = title, fontSize = 20.sp)
        },
        text = {
            Text(text = body)
        }
    )
}