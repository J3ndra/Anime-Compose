package com.kohendru.animecompose.data.source.remote

import com.kohendru.animecompose.data.source.remote.response.AnimesResponse
import com.kohendru.animecompose.data.source.remote.response.characterAndStaff.CharacterAndStaffResponse
import com.kohendru.animecompose.data.source.remote.response.characterDetails.CharacterResponse
import com.kohendru.animecompose.data.source.remote.response.details.AnimeDetailsResponse
import com.kohendru.animecompose.data.source.remote.response.episodes.EpisodesResponse
import com.kohendru.animecompose.data.source.remote.response.person.PersonResponse
import com.kohendru.animecompose.data.source.remote.response.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {

    // GET ANIMES
    @GET("top/anime/{page}")
    suspend fun getAnimes(
        @Path("page") page: Int
    ): AnimesResponse

    // GET ANIME DETAILS
    @GET("anime/{mal_id}")
    suspend fun getAnimeDetails(
        @Path("mal_id") mal_id: Int
    ): AnimeDetailsResponse

    // GET ANIME EPISODES
    @GET("anime/{mal_id}/episodes/{page}")
    suspend fun getAnimeEpisodes(
        @Path("mal_id") mal_id: Int,
        @Path("page") page: Int
    ): EpisodesResponse

    // GET ANIME CHARACTER AND STAFF
    @GET("anime/{mal_id}/characters_staff")
    suspend fun getAnimeCharacterAndStaff(
        @Path("mal_id") mal_id: Int
    ): CharacterAndStaffResponse

    // GET CHARACTER DETAILS
    @GET("character/{mal_id}")
    suspend fun getCharacterDetails(
        @Path("mal_id") mal_id: Int
    ): CharacterResponse

    // GET PERSON DETAILS
    @GET("person/{mal_id}")
    suspend fun getPersonDetails(
        @Path("mal_id") mal_id: Int
    ): PersonResponse

    // GET SEARCH ANIMES
    @GET("search/anime")
    suspend fun getSearchAnimes(
        @Query("q") q: String,
        @Query("page") page: Int
    ): SearchResponse
}