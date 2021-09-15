package com.kohendru.animecompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kohendru.animecompose.ui.main.MainScreen
import com.kohendru.animecompose.ui.theme.AnimeComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    @ExperimentalComposeUiApi
    @FlowPreview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(Color(0xFF27468C))
                systemUiController.setNavigationBarColor(Color(0xFF1E3469))
            }

            ProvideWindowInsets {
                AnimeComposeTheme {
                    MainScreen()
                }
            }
        }
    }
}