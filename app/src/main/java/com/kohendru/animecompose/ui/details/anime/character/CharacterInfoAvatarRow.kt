package com.kohendru.animecompose.ui.details.anime.character

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.domain.entities.characterDetails.Character
import com.kohendru.animecompose.ui.details.anime.AnimeInfoHeader
import com.kohendru.animecompose.ui.details.anime.subtitleTextStyle
import com.kohendru.animecompose.R
import com.kohendru.animecompose.ui.details.anime.buttonTextStyle

@Composable
fun CharacterInfoAvatarRow(
    character: Character,
    openUrl: (url: String) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        CharacterImage(
            characterImageUrl = character.image_url,
            modifier = Modifier
                .weight(2f)
                .aspectRatio(2 / 3f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            if (character.name.isNullOrEmpty().not()) {
                AnimeInfoHeader(title = character.name!!)
            }

            if (character.name_kanji.isNullOrEmpty().not()) {
                Text(
                    text = character.name_kanji!!,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = subtitleTextStyle
                )
            }

            if (character.nicknames.isNullOrEmpty().not()) {
                Text(
                    text = stringResource(
                        id = R.string.character_nickname,
                        formatArgs = arrayOf(character.nicknames!!)
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = subtitleTextStyle
                )
            }

            if (character.url.isNullOrEmpty().not()) {
                Text(
                    text = stringResource(R.string.character_url),
                    color = Color(0xFF2E51A2),
                    style = buttonTextStyle,
                    modifier = Modifier
                        .clickable { openUrl(character.url!!) }
                        .padding(16.dp)
                )
            }
        }
    }
}