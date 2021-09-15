package com.kohendru.animecompose.ui.common

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.material.snackbar.Snackbar
import com.kohendru.animecompose.domain.entities.Anime
import com.kohendru.animecompose.network.ConnectionState
import com.kohendru.animecompose.network.connectivityState
import kotlinx.coroutines.launch

@Composable
fun AnimeItem(
    anime: Anime,
    modifier: Modifier = Modifier,
    onAnimeClick: (malId: Int) -> Unit
) {
    val context = LocalContext.current
    val connection by connectivityState()
    val isConnected = connection === ConnectionState.Available

    Row(
        modifier = modifier
            .clickable {
                if (!isConnected) {
                    showMessage(context, message = "Cannot fetch anime details, please check your internet connection ((´д｀)).")
                } else {
                    onAnimeClick(anime.mal_id)
                }
            }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        AnimePoster(
            posterUrl = anime.image_url,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(2 / 3f)
        )

        AnimeItemDetails(
            anime = anime,
            modifier = Modifier
                .weight(4f)
                .padding(horizontal = 16.dp)
        )
    }
}

fun showMessage(context: Context, message:String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}