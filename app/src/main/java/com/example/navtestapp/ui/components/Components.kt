package com.example.navtestapp.ui.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navtestapp.ui.features.home.friendsList.FriendsListViewModel
import kotlinx.coroutines.delay

@Composable
fun HeaderTextComponent(
    name: String
) {
    Text(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
        text = name,
        fontSize = 26.sp,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderTextComponentPreview() {
    HeaderTextComponent(name = "sample")
}

@Composable
fun AuthTextField(
    val1: String,
    change: (String) -> Unit,
    placeHolder: String,
    imageVector: ImageVector
) {
    OutlinedTextField(
        value = val1,
        onValueChange = change,
        Modifier
            .clip(shape = RectangleShape)
            .fillMaxWidth()
            .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
        placeholder = {
            Text(text = placeHolder)
        },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = null)
        },
        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = MaterialTheme.colorScheme.onBackground, unfocusedTextColor = MaterialTheme.colorScheme.onBackground)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AuthTextFieldPreview() {
    AuthTextField(val1 = "", change = {}, placeHolder = "test", imageVector = Icons.Default.Email)
}

@Composable
fun PasswordTextField(
    val1: String,
    change: (String) -> Unit,
    placeHolder: String,
    imageVector: ImageVector
) {
    OutlinedTextField(
        value = val1,
        onValueChange = change,
        Modifier
            .clip(shape = RectangleShape)
            .fillMaxWidth()
            .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
        placeholder = {
            Text(text = placeHolder)
        },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = null)
        },
        visualTransformation = PasswordVisualTransformation(),
        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = MaterialTheme.colorScheme.onBackground, unfocusedTextColor = MaterialTheme.colorScheme.onBackground)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    PasswordTextField(val1 = "", change = {}, placeHolder = "test", imageVector = Icons.Default.Lock)
}

@Composable
fun PhoneNumberTextField(
    val1: String,
    change: (String) -> Unit,
    placeHolder: String,
    imageVector: ImageVector
) {
    OutlinedTextField(
        value = val1,
        onValueChange = change,
        Modifier
            .clip(shape = RectangleShape)
            .fillMaxWidth()
            .absolutePadding(16.dp, 0.dp, 16.dp, 0.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = {
            Text(text = placeHolder)
        },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = null)
        },
        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = MaterialTheme.colorScheme.onBackground, unfocusedTextColor = MaterialTheme.colorScheme.onBackground)
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PhoneNumberTextFieldPreview() {
    PasswordTextField(val1 = "", change = {}, placeHolder = "test", imageVector = Icons.Default.Phone)
}

@Composable
fun AuthButton(
    change: () -> Unit,
    lbl: String
) {
    Button(
        onClick = change,
        modifier = Modifier
            .clip(shape = RectangleShape)
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
    ) {
        Text(text = lbl, fontSize = 25.sp, color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthButtonPreview() {
    AuthButton(change = {}, lbl = "test")
}

@Composable
fun AppButton(
    change: () -> Unit,
    lbl: String
) {
    Button(
        onClick = change,
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .clip(shape = RectangleShape)
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
    ) {
        Text(text = lbl, color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppButtonPreview() {
    AppButton(change = {}, lbl = "test")
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

@Preview
@Composable
fun AlertDialogComponentPreview() {
    AlertDialogComponent(onDismiss = {}, title = "test", body = "test")
}