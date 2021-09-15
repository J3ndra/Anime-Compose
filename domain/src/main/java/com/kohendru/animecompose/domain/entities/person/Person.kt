package com.kohendru.animecompose.domain.entities.person

data class Person(
    val about: String?,
    val alternate_names: List<Any>?,
    val anime_staff_positions: List<Any>?,
    val birthday: String?,
    val family_name: String?,
    val given_name: String?,
    val image_url: String?,
    val mal_id: Int?,
    val member_favorites: Int?,
    val name: String?,
    val published_manga: List<Any>?,
    val url: String?,
    val voice_acting_roles: List<VoiceActingRole>?,
    val website_url: String?
)