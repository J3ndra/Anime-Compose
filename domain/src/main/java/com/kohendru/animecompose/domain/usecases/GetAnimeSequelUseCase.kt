package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.details.Sequel
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetAnimeSequelUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

//    suspend operator fun invoke(malId: Int): List<Sequel> {
//        return animeGateway.getAnimeSequel(malId).sequel
//    }
}