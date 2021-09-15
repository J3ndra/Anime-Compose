package com.kohendru.animecompose.data.source.remote.response.episodes


import com.google.gson.annotations.SerializedName

data class EpisodesResponse(
    @SerializedName("episodes")
    val episodes: List<NetworkEpisode>
)