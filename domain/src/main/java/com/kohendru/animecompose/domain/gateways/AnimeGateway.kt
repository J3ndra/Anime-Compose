package com.kohendru.animecompose.domain.gateways

import com.kohendru.animecompose.domain.entities.Animes
import com.kohendru.animecompose.domain.entities.characterAndStaff.CharactersAndStaff
import com.kohendru.animecompose.domain.entities.characterDetails.Character
import com.kohendru.animecompose.domain.entities.details.*
import com.kohendru.animecompose.domain.entities.episodes.Episodes
import com.kohendru.animecompose.domain.entities.person.Person
import com.kohendru.animecompose.domain.entities.search.Search

interface AnimeGateway {
    suspend fun getAnimes(page: Int): Animes

    suspend fun getAnimeDetails(malId: Int): AnimeDetails
    suspend fun getAnimeEpisodes(page: Int, malId: Int): Episodes
    suspend fun getAnimeCharacterAndStaff(malId: Int): CharactersAndStaff

    suspend fun getCharacterDetails(malId: Int): Character
    suspend fun getPersonDetails(malId: Int): Person

    suspend fun getSearchAnimes(q: String, page: Int): Search

//    suspend fun getAnimesByGenre(malId: Int, page: Int): AnimesByGenre
}