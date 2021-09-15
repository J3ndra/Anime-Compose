package com.kohendru.animecompose.domain.entities.search

data class SearchResult(
    val airing: Boolean?,
    val end_date: String?,
    val episodes: Int?,
    val image_url: String?,
    val mal_id: Int?,
    val members: Int?,
    val rated: String?,
    val score: Double?,
    val start_date: String?,
    val synopsis: String?,
    val title: String?,
    val type: String?,
    val url: String?
)