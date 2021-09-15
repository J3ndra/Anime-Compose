package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.details.Prequel
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetAnimePrequelUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

//    suspend operator fun invoke(malId: Int): List<Prequel> {
//        return animeGateway.getAnimePrequel(malId).prequel
//    }
}