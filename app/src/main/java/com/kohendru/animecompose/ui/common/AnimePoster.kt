package com.kohendru.animecompose.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MovieFilter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun AnimePoster(
    posterUrl: String?,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        if (posterUrl == null) {
            AnimePosterPlaceholder(modifier.matchParentSize())
        } else {
            val painter = rememberGlidePainter(request = posterUrl)

            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .matchParentSize()
                    .clip(MaterialTheme.shapes.medium)
            )

            when(painter.loadState) {
                is ImageLoadState.Loading -> {
                    CircularProgressIndicator(
                        modifier = modifier.size(24.dp),
                        strokeWidth = 2.dp
                    )
                }
                is ImageLoadState.Error -> AnimePosterPlaceholder(modifier)
            }
        }

    }
}

@Composable
fun AnimePosterPlaceholder(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.background(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colors.surface,
        ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.MovieFilter,
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = modifier.scale(1.5f)
        )
    }
}