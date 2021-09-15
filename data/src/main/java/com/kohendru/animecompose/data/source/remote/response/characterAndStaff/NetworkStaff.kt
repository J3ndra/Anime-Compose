package com.kohendru.animecompose.data.source.remote.response.characterAndStaff


import com.google.gson.annotations.SerializedName

data class NetworkStaff(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("positions")
    val positions: List<String>?,
    @SerializedName("url")
    val url: String?
)