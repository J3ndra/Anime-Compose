package com.kohendru.animecompose.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kohendru.animecompose.network.checkIfOnline
import com.kohendru.animecompose.ui.common.OfflineDialog
import kotlinx.coroutines.FlowPreview

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@FlowPreview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val rootScreen = listOf(RootScreen.Animes)
    val mainRoutes = listOf(LeafScreen.Animes).map { it.route }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    val showBottomBar = currentRoute in mainRoutes

    val context = LocalContext.current
    var isOnline by remember {
        mutableStateOf(checkIfOnline(context))
    }

    if (isOnline) {
        Scaffold(
            bottomBar = {
                if (showBottomBar) AnimeComposeBottomBar(navController, rootScreen)
            },
            content = {
                Box(Modifier.fillMaxSize()) {
                    AnimeComposeNavHost(navController)
                }
            }
        )
    } else {
        OfflineDialog {
            isOnline = checkIfOnline(context)
        }
    }
}

