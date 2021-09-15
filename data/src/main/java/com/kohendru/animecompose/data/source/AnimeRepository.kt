package com.kohendru.animecompose.data.source

import com.kohendru.animecompose.data.source.remote.RemoteAnimeDataSource
import com.kohendru.animecompose.domain.entities.Animes
import com.kohendru.animecompose.domain.entities.characterAndStaff.CharactersAndStaff
import com.kohendru.animecompose.domain.entities.characterDetails.Character
import com.kohendru.animecompose.domain.entities.details.AnimeDetails
import com.kohendru.animecompose.domain.entities.episodes.Episodes
import com.kohendru.animecompose.domain.entities.person.Person
import com.kohendru.animecompose.domain.entities.search.Search
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val remoteAnimeDataSource: RemoteAnimeDataSource
): AnimeGateway {

    override suspend fun getAnimes(page: Int): Animes {
        return remoteAnimeDataSource.getAnimes(page)
    }

    override suspend fun getAnimeDetails(malId: Int): AnimeDetails {
        return remoteAnimeDataSource.getAnimeDetails(malId)
    }

    override suspend fun getAnimeEpisodes(malId: Int, page: Int): Episodes {
        return remoteAnimeDataSource.getAnimeEpisodes(malId, page)
    }

    override suspend fun getAnimeCharacterAndStaff(malId: Int): CharactersAndStaff {
        return remoteAnimeDataSource.getAnimeCharacterAndStaff(malId)
    }

    override suspend fun getCharacterDetails(malId: Int): Character {
        return remoteAnimeDataSource.getCharacterDetails(malId)
    }

    override suspend fun getPersonDetails(malId: Int): Person {
        return remoteAnimeDataSource.getPersonDetails(malId)
    }

    override suspend fun getSearchAnimes(q: String, page: Int): Search {
        return remoteAnimeDataSource.getSearchAnimes(q, page)
    }
}