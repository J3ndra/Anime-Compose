package com.kohendru.animecompose.data.source.remote.response.person


import com.google.gson.annotations.SerializedName

data class NetworkAnime(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)