package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.details.Adaptation
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetAnimeAdaptionUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

//    suspend operator fun invoke(malId: Int): List<Adaptation> {
//        return animeGateway.getAnimeAdaption(malId).adaptation
//    }
}