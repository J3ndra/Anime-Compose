package com.kohendru.animecompose.data.source.remote.response.characterAndStaff


import com.google.gson.annotations.SerializedName

data class NetworkCharacter(
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("role")
    val role: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("voice_actors")
    val voiceActors: List<NetworkVoiceActor>
)