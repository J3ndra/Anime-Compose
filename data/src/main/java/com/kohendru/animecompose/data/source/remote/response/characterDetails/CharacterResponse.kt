package com.kohendru.animecompose.data.source.remote.response.characterDetails


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("about")
    val about: String?,
    @SerializedName("animeography")
    val animeography: List<NetworkAnimeography>?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("mangaography")
    val mangaography: List<NetworkMangaography>?,
    @SerializedName("member_favorites")
    val memberFavorites: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("name_kanji")
    val nameKanji: String?,
    @SerializedName("nicknames")
    val nicknames: List<String>?,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    val requestCached: Boolean?,
    @SerializedName("request_hash")
    val requestHash: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("voice_actors")
    val voiceActors: List<NetworkVoiceActor>?
)