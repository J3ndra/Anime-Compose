package com.kohendru.animecompose.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.R
import com.kohendru.animecompose.ui.details.anime.buttonTextStyle
import com.kohendru.animecompose.ui.details.anime.subtitleTextStyle

@Composable
fun PagingErrorMessage(
    modifier: Modifier = Modifier,
    message: String,
    onRetryClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            style = subtitleTextStyle,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.error
        )

        Spacer(modifier = modifier.height(16.dp))

        Button(onClick = onRetryClick, colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF2E51A2),
            contentColor = Color.White
        )) {
            Text(text = stringResource(R.string.try_again), style = buttonTextStyle)
        }

    }
}