package com.kohendru.animecompose.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class AnimesResponse(
    @SerializedName("top")
    val top: List<NetworkAnime>
)