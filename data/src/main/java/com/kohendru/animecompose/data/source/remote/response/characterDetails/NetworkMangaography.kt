package com.kohendru.animecompose.data.source.remote.response.characterDetails


import com.google.gson.annotations.SerializedName

data class NetworkMangaography(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("url")
    val url: String?
)