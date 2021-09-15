package com.kohendru.animecompose.ui.animes

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.kohendru.animecompose.ui.details.anime.titleTextStyle

@Composable
fun AnimesComposeTopBar() {
    TopAppBar(
        backgroundColor = Color(0xFF2E51A2),
        contentColor = Color.White,
        title = {
            Text(text = "Animes", style = titleTextStyle)
        }
    )
}