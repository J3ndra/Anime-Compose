package com.kohendru.animecompose.domain.entities.details

import com.kohendru.animecompose.domain.entities.Anime

data class AnimeDetails(
    val anime: Anime,
    val aired: Aired?,
    val airing: Boolean?,
    val background: String?,
    val broadcast: String?,
    val duration: String?,
    val ending_themes: List<String>?,
    val favorites: Int?,
    val genres: List<Genre>?,
    val image_url: String?,
    val licensors: List<Licensor>?,
    val opening_themes: List<String>?,
    val popularity: Int?,
    val premiered: String?,
    val producers: List<Producer>?,
    val rating: String?,
    val related: Related?,
    val scored_by: Int?,
    val source: String?,
    val status: String?,
    val studios: List<Studio>?,
    val synopsis: String?,
    val title: String?,
    val title_english: String?,
    val title_japanese: String?,
    val title_synonyms: List<String>?,
    val trailer_url: Any?,
    val url: String?
)