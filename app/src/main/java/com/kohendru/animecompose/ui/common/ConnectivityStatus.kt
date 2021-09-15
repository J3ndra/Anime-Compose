package com.kohendru.animecompose.ui.common

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kohendru.animecompose.network.ConnectionState
import com.kohendru.animecompose.network.connectivityState
import com.kohendru.animecompose.ui.details.anime.subtitleTextStyle
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun ConnectivityStatus() {
    val connection by connectivityState()
    val isConnected = connection === ConnectionState.Available

    var visibility by remember {
        mutableStateOf(false)
    }

    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        ConnectivityStatusBox(isConnected = isConnected)
    }

    LaunchedEffect(isConnected) {
        if (!isConnected) {
            visibility = true
        } else {
            delay(2000)
            visibility = false
        }
    }
}

@Composable
fun ConnectivityStatusBox(isConnected: Boolean) {
    val backgrondColor by animateColorAsState(if (isConnected) Color(0xFF2E51A2) else Color(0xFFEB6100))
    val message = if(isConnected) "Back Online!" else "No Internet Connection!"
    val iconResource = if (isConnected) {
        Icons.Default.Wifi
    } else {
        Icons.Default.WifiOff
    }

    Box(
        modifier = Modifier
            .background(backgrondColor)
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(iconResource, "Connectivity Icon", tint = Color.White)
            Spacer(modifier = Modifier.size(8.dp))
            Text(message, color = Color.White, style = subtitleTextStyle)
        }
    }
}