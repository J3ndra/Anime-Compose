package com.kohendru.animecompose.data.source.remote.response.animeByGenre


import com.google.gson.annotations.SerializedName

data class AnimesByGenreResponse(
    @SerializedName("anime")
    val anime: List<Anime>?,
    @SerializedName("item_count")
    val itemCount: Int?,
    @SerializedName("mal_url")
    val malUrl: MalUrl?
)