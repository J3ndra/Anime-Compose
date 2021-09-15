package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.animeByGenre.AnimesByGenre
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetAnimeByGenreUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

//    suspend operator fun invoke(malId: Int, page: Int): AnimesByGenre {
//        return animeGateway.getAnimesByGenre(malId, page)
//    }
}