package com.kohendru.animecompose.domain.entities.animeByGenre

data class AnimesByGenre(
    val anime: List<AnimeByGenre>?,
    val item_count: Int?,
    val mal_url: MalUrl?
)