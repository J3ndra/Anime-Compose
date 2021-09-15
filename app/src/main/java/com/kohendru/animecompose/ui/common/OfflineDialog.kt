package com.kohendru.animecompose.ui.common

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.kohendru.animecompose.R
import com.kohendru.animecompose.ui.details.anime.buttonTextStyle
import com.kohendru.animecompose.ui.details.anime.subtitleTextStyle
import com.kohendru.animecompose.ui.details.anime.titleTextStyle

@Composable
fun OfflineDialog(onRetry: () -> Unit){
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(
                text = stringResource(R.string.connection_error_title),
                style = titleTextStyle
            )
        },
        text = {
            Text(
                text = stringResource(R.string.connection_error_message),
                style = subtitleTextStyle
            )
        },
        confirmButton = {
            TextButton(onClick = onRetry) {
                Text(
                    text = stringResource(R.string.try_again),
                    style = buttonTextStyle,
                    color = Color(0xFF2E51A2)
                )
            }
        }
    )
}