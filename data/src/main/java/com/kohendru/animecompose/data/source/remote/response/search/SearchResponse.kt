package com.kohendru.animecompose.data.source.remote.response.search


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("last_page")
    val lastPage: Int?,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int?,
    @SerializedName("request_cached")
    val requestCached: Boolean?,
    @SerializedName("request_hash")
    val requestHash: String?,
    @SerializedName("results")
    val results: List<NetworkResult>?
)