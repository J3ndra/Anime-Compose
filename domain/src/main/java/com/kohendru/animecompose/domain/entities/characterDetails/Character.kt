package com.kohendru.animecompose.domain.entities.characterDetails

data class Character(
    val about: String?,
    val animeography: List<Animeography>?,
    val image_url: String?,
    val mal_id: Int?,
    val mangaography: List<Mangaography>?,
    val member_favorites: Int?,
    val name: String?,
    val name_kanji: String?,
    val nicknames: List<String>?,
    val url: String?,
    val voice_actors: List<VoiceActor>?
)