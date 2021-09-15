package com.kohendru.animecompose.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kohendru.animecompose.R
import com.kohendru.animecompose.domain.entities.Anime
import com.kohendru.animecompose.ui.theme.animesFontFamily

@Composable
fun AnimeItemDetails(
    anime: Anime,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        val titleTextStyle = TextStyle(
            fontFamily = animesFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            letterSpacing = 0.15.sp
        )

        val typeTextStyle = TextStyle(
            fontFamily = animesFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            letterSpacing = 0.15.sp
        )

        val subtitleTextStyle = TextStyle(
            fontFamily = animesFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.15.sp
        )

        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = anime.title ?: "",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = titleTextStyle
        )

        Spacer(modifier = Modifier.width(16.dp))

        if (anime.type != null) {
            Text(
                text = stringResource(
                    id = R.string.type,
                    formatArgs = arrayOf(anime.type!!)
                ),
                style = typeTextStyle
            )
        }

        if (anime.episodes != null) {
            Text(
                text = stringResource(
                    id = R.string.episodes,
                    formatArgs = arrayOf(anime.episodes!!)
                ),
                style = subtitleTextStyle
            )
        }

        if (anime.score != null) {
            Text(
                text = stringResource(
                    id = R.string.scores,
                    formatArgs = arrayOf(anime.score!!)
                ),
                style = subtitleTextStyle
            )
        }
    }
}