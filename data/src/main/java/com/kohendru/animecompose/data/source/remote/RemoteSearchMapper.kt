package com.kohendru.animecompose.data.source.remote

import com.kohendru.animecompose.data.source.remote.response.search.NetworkResult
import com.kohendru.animecompose.data.source.remote.response.search.SearchResponse
import com.kohendru.animecompose.domain.entities.search.Search
import com.kohendru.animecompose.domain.entities.search.SearchResult

fun SearchResponse.asSearchAnimes() = Search(
    results = results?.map { it.asSearchAnime() },
    last_page = lastPage
)

fun NetworkResult.asSearchAnime() = SearchResult(
    mal_id = malId,
    url = url,
    image_url = imageUrl,
    title = title,
    airing = airing,
    synopsis = synopsis,
    type = type,
    episodes = episodes,
    score = score,
    start_date = startDate,
    end_date = endDate,
    members = members,
    rated = rated
)