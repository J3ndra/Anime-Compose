package com.kohendru.animecompose.data.source.remote.response.animeByGenre


import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("airing_start")
    val airingStart: String?,
    @SerializedName("episodes")
    val episodes: Int?,
    @SerializedName("genres")
    val genres: List<Genre>?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("licensors")
    val licensors: List<String>?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("members")
    val members: Int?,
    @SerializedName("producers")
    val producers: List<Producer>?,
    @SerializedName("score")
    val score: Double?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("synopsis")
    val synopsis: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)