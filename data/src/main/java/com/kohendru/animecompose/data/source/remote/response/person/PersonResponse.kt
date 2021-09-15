package com.kohendru.animecompose.data.source.remote.response.person


import com.google.gson.annotations.SerializedName

data class PersonResponse(
    @SerializedName("about")
    val about: String?,
    @SerializedName("alternate_names")
    val alternateNames: List<Any>?,
    @SerializedName("anime_staff_positions")
    val animeStaffPositions: List<Any>?,
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("family_name")
    val familyName: String?,
    @SerializedName("given_name")
    val givenName: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("mal_id")
    val malId: Int?,
    @SerializedName("member_favorites")
    val memberFavorites: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("published_manga")
    val publishedManga: List<Any>?,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    val requestCached: Boolean?,
    @SerializedName("request_hash")
    val requestHash: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("voice_acting_roles")
    val voiceActingRoles: List<NetworkVoiceActingRole>?,
    @SerializedName("website_url")
    val websiteUrl: String?
)