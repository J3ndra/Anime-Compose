package com.kohendru.animecompose.domain.entities.details

data class Related(
    val adaptation: List<Adaptation>?,
    val prequel: List<Prequel>?,
    val sequel: List<Sequel>?
)