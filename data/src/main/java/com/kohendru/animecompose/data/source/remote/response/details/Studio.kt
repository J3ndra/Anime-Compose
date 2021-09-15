package com.kohendru.animecompose.data.source.remote.response.details


import com.google.gson.annotations.SerializedName

data class Studio(
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("type")
    val type: String?
)