package com.kohendru.animecompose.ui.details.anime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.domain.entities.characterAndStaff.Character
import com.kohendru.animecompose.ui.common.Carousel

@Composable
fun AnimeCharacterCarousel(
    character: List<Character>,
    onItemClick: (character: Character) -> Unit,
    modifier: Modifier = Modifier
) {
    Carousel(
        items = character,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        itemSpacing = 4.dp,
        modifier = modifier
    ) { item, padding ->
        CharacterCard(
            character = item,
            onItemClick = onItemClick,
            modifier = Modifier
                .padding(padding)
                .fillParentMaxHeight()
                .aspectRatio(2/3f)
        )
    }
}