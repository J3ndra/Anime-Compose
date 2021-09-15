package com.kohendru.animecompose.data.source.remote.response.characterAndStaff


import com.google.gson.annotations.SerializedName

data class CharacterAndStaffResponse(
    @SerializedName("characters")
    val characters: List<NetworkCharacter>,
    @SerializedName("staff")
    val staff: List<NetworkStaff>
)