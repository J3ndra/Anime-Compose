package com.kohendru.animecompose.ui.details.anime

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.kohendru.animecompose.domain.entities.details.AnimeDetails
import com.kohendru.animecompose.network.shareUrl
import com.kohendru.animecompose.ui.common.AnimePoster
import com.kohendru.animecompose.ui.theme.animesFontFamily

val titleTextStyle = TextStyle(
    fontFamily = animesFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 18.sp,
    letterSpacing = 0.15.sp
)
val subtitleTextStyle = TextStyle(
    fontFamily = animesFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.15.sp
)

val genreTextStyle = TextStyle(
    fontFamily = animesFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    letterSpacing = 0.15.sp
)

val buttonTextStyle = TextStyle(
    fontFamily = animesFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
    letterSpacing = 0.15.sp
)

@Composable
fun AnimeInfoPosterRow(
    animeDetails: AnimeDetails
) {

    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        AnimePoster(
            posterUrl = animeDetails.image_url,
            modifier = Modifier
                .weight(2f)
                .aspectRatio(2 / 3f)
        )

        AnimeInfo(
            animeDetails = animeDetails,
            modifier = Modifier
                .weight(3f)
                .padding(start = 16.dp)
        )

    }
}

@Composable
private fun AnimeInfo(
    animeDetails: AnimeDetails,
    modifier: Modifier = Modifier
){
    val context = LocalContext.current

    Column(modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = animeDetails.title ?: "",
            style = titleTextStyle
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = animeDetails.title_japanese ?: "",
            style = subtitleTextStyle
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            mainAxisSpacing = 4.dp,
            crossAxisSpacing = 8.dp
        ) {
            animeDetails.genres?.forEach {
                if (it.name != null) GenreChip(genreName = it.name!!)
            }
        }
    }
}

@Composable
private fun GenreChip(genreName: String) {
    Surface(
        elevation = 4.dp,
        shape = RoundedCornerShape(100),
        color = Color(0xFF2E51A2)
    ) {
        Text(
            text = genreName,
            style = genreTextStyle,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}