package com.kohendru.animecompose.ui.details.anime.character

import androidx.compose.foundation.clickable
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kohendru.animecompose.domain.entities.characterDetails.VoiceActor

@Composable
fun VoiceActorCard(
    voiceActor: VoiceActor,
    modifier: Modifier = Modifier,
    onItemClick: (url: String) -> Unit
) {
    Card(
        modifier = modifier
    ) {
        Card(modifier = modifier) {
            CharacterImage(
                voiceActor.image_url,
                modifier = Modifier.clickable { onItemClick(voiceActor.url!!) }
            )
        }
    }
}