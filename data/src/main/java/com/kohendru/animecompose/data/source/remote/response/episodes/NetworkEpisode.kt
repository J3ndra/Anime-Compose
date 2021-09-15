package com.kohendru.animecompose.data.source.remote.response.episodes


import com.google.gson.annotations.SerializedName

data class NetworkEpisode(
    @SerializedName("aired")
    val aired: String?,
    @SerializedName("episode_id")
    val episodeId: Int?,
    @SerializedName("filler")
    val filler: Boolean?,
    @SerializedName("forum_url")
    val forumUrl: String?,
    @SerializedName("recap")
    val recap: Boolean?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("title_japanese")
    val titleJapanese: String?,
    @SerializedName("title_romanji")
    val titleRomanji: String?,
    @SerializedName("video_url")
    val videoUrl: String?
)