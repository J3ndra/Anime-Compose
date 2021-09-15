package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.details.AnimeDetails
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetAnimeDetailsUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

    suspend operator fun invoke(malId: Int): AnimeDetails {
        return animeGateway.getAnimeDetails(malId)
    }
}