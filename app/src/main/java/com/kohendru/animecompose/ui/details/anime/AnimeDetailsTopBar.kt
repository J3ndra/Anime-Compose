package com.kohendru.animecompose.ui.details.anime

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.kohendru.animecompose.R
import com.kohendru.animecompose.network.shareUrl

@Composable
fun AnimeDetailsTopBar(
    title: String,
    upPressed: () -> Unit,
    url: String
) {
    val context = LocalContext.current

    TopAppBar(
        backgroundColor = Color(0xFF2E51A2),
        contentColor = Color.White,
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = titleTextStyle
            )
        },
        navigationIcon = {
            IconButton(onClick = upPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.topbar_up_button_content_description)
                )
            }
        },
        actions = {
            IconButton(onClick = {
                shareUrl(url = url, context = context)
            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )
            }
        }
    )
}