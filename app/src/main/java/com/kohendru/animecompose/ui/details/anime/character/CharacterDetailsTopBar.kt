package com.kohendru.animecompose.ui.details.anime.character

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.R

@Composable
fun CharacterDetailsTopBar(
    upPressed: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color(0xFF2E51A2),
        contentColor = Color.White,
        title = {
            Text(
                modifier = Modifier.padding(end = 32.dp),
                text = stringResource(R.string.character_details),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = upPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.topbar_up_button_content_description),
                )
            }
        }
    )
}