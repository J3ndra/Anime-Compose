package com.kohendru.animecompose.data.source.remote.response.animeByGenre


import com.google.gson.annotations.SerializedName

data class Producer(
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)