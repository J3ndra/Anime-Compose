package com.kohendru.animecompose.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.R
import com.kohendru.animecompose.ui.details.anime.buttonTextStyle
import com.kohendru.animecompose.ui.details.anime.subtitleTextStyle

@Composable
fun PagingErrorItem(
    message: String,
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = message,
            maxLines = 1,
            modifier = modifier.weight(1f),
            style = subtitleTextStyle,
            color = MaterialTheme.colors.error
        )
        Button(onClick = onRetryClick, colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF2E51A2),
            contentColor = Color.White
        )) {
            Text(text = stringResource(R.string.try_again), style = buttonTextStyle)
        }
    }
}