package com.kohendru.animecompose.domain.entities.characterAndStaff

data class Character(
    val image_url: String?,
    val mal_id: Int?,
    val name: String?,
    val role: String?,
    val url: String?,
    val voice_actors: List<VoiceActor>?
)