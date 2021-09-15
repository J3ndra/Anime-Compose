package com.kohendru.animecompose.ui.details.anime.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun CharacterImage(
    characterImageUrl: String?,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        if (characterImageUrl == null) {
            PlaceholderCharacterImage(modifier.matchParentSize())
        } else {
            val painter = rememberGlidePainter(request = characterImageUrl, fadeIn = true)

            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(MaterialTheme.shapes.medium)
            )

            when (painter.loadState) {
                is ImageLoadState.Loading -> LoadingCharacterImage(modifier.matchParentSize())
                is ImageLoadState.Error -> PlaceholderCharacterImage(modifier.matchParentSize())
            }
        }
    }
}

@Composable
private fun PlaceholderCharacterImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.background(
            shape = MaterialTheme.shapes.medium,
            color = Color.Gray
        )
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.scale(2f)
        )
    }
}

@Composable
private fun LoadingCharacterImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            strokeWidth = 2.dp
        )
    }
}