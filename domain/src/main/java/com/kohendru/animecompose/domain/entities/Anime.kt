package com.kohendru.animecompose.domain.entities

data class Anime(
    val episodes: Int?,
    val image_url: String?,
    val mal_id: Int,
    val members: Int?,
    val rank: Int?,
    val score: Double?,
    val title: String?,
    val type: String?,
    val url: String?
)