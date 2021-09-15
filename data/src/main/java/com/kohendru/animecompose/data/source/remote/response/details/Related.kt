package com.kohendru.animecompose.data.source.remote.response.details


import com.google.gson.annotations.SerializedName

data class Related(
    @SerializedName("Adaptation")
    val adaptation: List<Adaptation>?,
    @SerializedName("Prequel")
    val prequel: List<Prequel>?,
    @SerializedName("Sequel")
    val sequel: List<Sequel>?
)