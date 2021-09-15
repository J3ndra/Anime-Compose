package com.kohendru.animecompose.data.source.remote.response.person


import com.google.gson.annotations.SerializedName

data class NetworkVoiceActingRole(
    @SerializedName("anime")
    val anime: NetworkAnime?,
    @SerializedName("character")
    val character: NetworkCharacter?,
    @SerializedName("role")
    val role: String?
)