package com.kohendru.animecompose.ui.details.anime

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.domain.entities.details.AnimeDetails

@Composable
fun AnimeInfoRating(
    animeDetails: AnimeDetails
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider()

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {

            if(animeDetails.aired?.string != null) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
                )
                Text(
                    text = animeDetails.aired?.string!!,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    style = subtitleTextStyle
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            if(animeDetails.anime.score != null) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = null
                )
                Text(
                    text = "${animeDetails.anime.score}/10",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    style = subtitleTextStyle
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            if(animeDetails.anime.rank != null) {
                Icon(
                    imageVector = Icons.Default.ShowChart,
                    contentDescription = null
                )
                Text(
                    text = "${animeDetails.anime.rank}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    style = subtitleTextStyle
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }

        Divider()

    }
}