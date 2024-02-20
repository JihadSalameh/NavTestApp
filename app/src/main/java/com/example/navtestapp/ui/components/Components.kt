package com.example.navtestapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    OutlinedCard(
        modifier = Modifier
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(color),
        elevation = CardDefaults.cardElevation(12.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 55.dp, end = 10.dp)
                .size(30.dp)
        )
    }
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