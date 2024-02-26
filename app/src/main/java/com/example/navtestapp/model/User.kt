package com.example.navtestapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class User(
    val id: Int,
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
