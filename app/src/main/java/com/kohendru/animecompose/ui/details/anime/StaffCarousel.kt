package com.kohendru.animecompose.ui.details.anime

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.domain.entities.characterAndStaff.Staff
import com.kohendru.animecompose.ui.common.Carousel

@Composable
fun StaffCarousel(
    staff: List<Staff>,
    onItemClick: (url: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Carousel(
        items = staff,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        itemSpacing = 4.dp,
        modifier = modifier
    ) { item, padding ->
        StaffCard(
            staff = item,
            onItemClick = onItemClick,
            modifier = Modifier
                .padding(padding)
                .fillParentMaxHeight()
                .aspectRatio(2/3f)
        )
    }
}