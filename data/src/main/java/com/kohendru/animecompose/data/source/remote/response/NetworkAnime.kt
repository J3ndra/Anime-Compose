package com.kohendru.animecompose.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class NetworkAnime(
    @SerializedName("episodes")
    val episodes: Int?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("members")
    val members: Int?,
    @SerializedName("rank")
    val rank: Int?,
    @SerializedName("score")
    val score: Double?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)