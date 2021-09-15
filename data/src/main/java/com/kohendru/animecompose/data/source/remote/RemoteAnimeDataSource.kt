package com.kohendru.animecompose.data.source.remote

import com.kohendru.animecompose.domain.entities.Animes
import com.kohendru.animecompose.domain.entities.characterAndStaff.CharactersAndStaff
import com.kohendru.animecompose.domain.entities.characterDetails.Character
import com.kohendru.animecompose.domain.entities.details.AnimeDetails
import com.kohendru.animecompose.domain.entities.episodes.Episodes
import com.kohendru.animecompose.domain.entities.person.Person
import com.kohendru.animecompose.domain.entities.search.Search
import javax.inject.Inject

class RemoteAnimeDataSource @Inject constructor(
    private val animeService: AnimeService
) {

    suspend fun getAnimes(page: Int): Animes {
        return animeService.getAnimes(page).asAnimes()
    }

    suspend fun getAnimeDetails(malId: Int): AnimeDetails {
        return animeService.getAnimeDetails(malId).asAnimeDetails()
    }

    suspend fun getAnimeEpisodes(malId: Int, page: Int): Episodes {
        return animeService.getAnimeEpisodes(malId, page).asEpisodes()
    }

    suspend fun getAnimeCharacterAndStaff(malId: Int): CharactersAndStaff {
        return animeService.getAnimeCharacterAndStaff(malId).asCharacterAndStaff()
    }

    suspend fun getCharacterDetails(malId: Int): Character {
        return animeService.getCharacterDetails(malId).asCharacterDetails()
    }

    suspend fun getPersonDetails(malId: Int): Person {
        return animeService.getPersonDetails(malId).asPersonDetails()
    }

    suspend fun getSearchAnimes(q: String, page: Int): Search {
        return animeService.getSearchAnimes(q, page).asSearchAnimes()
    }
}