package com.kohendru.animecompose.domain.entities.characterAndStaff

data class Staff(
    val image_url: String?,
    val mal_id: Int?,
    val name: String?,
    val positions: List<String>?,
    val url: String?
)