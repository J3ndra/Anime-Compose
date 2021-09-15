package com.kohendru.animecompose.ui.details.anime

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.domain.entities.characterAndStaff.Character

@Composable
fun CharacterCard(
    character: Character,
    modifier: Modifier = Modifier,
    onItemClick: (character: Character) -> Unit
) {
    Card(modifier = modifier) {
        CharacterProfileImage(
            profileImageUrl = character.image_url,
            modifier = Modifier.clickable { onItemClick(character) }
        )

        Box(
            Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color.Transparent, Color.Black),
                        0f,
                        700f,
                    )
                )
        ) {
            Text(
                text = character.name!!,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp),
                style = titleTextStyle,
                color = Color.White,
                maxLines = 2
            )
        }
    }
}