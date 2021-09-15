package com.kohendru.animecompose.domain.entities.search

data class Search(
    val last_page: Int?,
    val results: List<SearchResult>?
)