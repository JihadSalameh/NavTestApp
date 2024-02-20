package com.example.navtestapp.ui.components

import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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