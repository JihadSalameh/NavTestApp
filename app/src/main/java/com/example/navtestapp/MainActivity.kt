package com.example.navtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.navtestapp.data.Datasource
import com.example.navtestapp.ui.features.AppNav
import com.example.navtestapp.ui.theme.NavTestAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val datasource = Datasource()
        userViewModel = UserViewModel(datasource)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.loading.value
            }
        }

        setContent {
            NavTestAppTheme {
                AppNav(userViewModel)
            }
        }
    }
}