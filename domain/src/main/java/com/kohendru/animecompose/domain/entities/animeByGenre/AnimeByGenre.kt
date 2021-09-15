package com.kohendru.animecompose.domain.entities.animeByGenre

data class AnimeByGenre(
    val airing_start: String?,
    val episodes: Int?,
    val genres: List<Genre>?,
    val image_url: String?,
    val licensors: List<String>?,
    val mal_id: Int?,
    val members: Int?,
    val producers: List<Producer>?,
    val score: Double?,
    val source: String?,
    val synopsis: String?,
    val title: String?,
    val type: String?,
    val url: String?
)