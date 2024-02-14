package com.example.navtestapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class User(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
