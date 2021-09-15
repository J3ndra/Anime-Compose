package com.kohendru.animecompose.ui.details.anime

import androidx.compose.foundation.clickable
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kohendru.animecompose.domain.entities.characterAndStaff.Staff
import com.kohendru.animecompose.ui.details.anime.character.CharacterImage

@Composable
fun StaffCard(
    staff: Staff,
    modifier: Modifier = Modifier,
    onItemClick: (url: String) -> Unit
) {
    Card(
        modifier = modifier
    ) {
        CharacterImage(
            characterImageUrl = staff.image_url,
            modifier = Modifier.clickable { onItemClick(staff.url!!) }
        )
    }
}