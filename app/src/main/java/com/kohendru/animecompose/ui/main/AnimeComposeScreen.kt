package com.kohendru.animecompose.ui.main

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MovieFilter
import androidx.compose.ui.graphics.vector.ImageVector
import com.kohendru.animecompose.R
import com.kohendru.animecompose.domain.entities.characterAndStaff.Character
import com.kohendru.animecompose.domain.entities.person.Person

sealed class RootScreen (
    val route: String,
    @StringRes val label: Int,
    val icon: ImageVector
) {

    object Animes : RootScreen(
        route = "animesroot",
        label = R.string.bottom_nav_item_label_animes,
        icon = Icons.Default.MovieFilter
    )
}

sealed class LeafScreen(val route: String) {
    object Animes : LeafScreen("animes")

    object AnimeDetails : LeafScreen("anime/{mal_id}") {
        fun createRoute(mal_id: Int): String = "anime/$mal_id"
    }

    object CharacterDetails : LeafScreen("character/{mal_id}") {
        fun createRoute(character: Character): String = "character/${character.mal_id}"
    }

    object PersonDetails : LeafScreen("person/{mal_id}") {
        fun createRoute(mal_id: Int): String = "person/${mal_id}"
    }
}