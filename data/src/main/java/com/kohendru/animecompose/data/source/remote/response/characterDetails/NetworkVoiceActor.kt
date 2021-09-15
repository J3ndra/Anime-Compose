package com.kohendru.animecompose.data.source.remote.response.characterDetails


import com.google.gson.annotations.SerializedName

data class NetworkVoiceActor(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)