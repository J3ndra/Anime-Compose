package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.Animes
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetAnimesUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

    suspend operator fun invoke(page: Int): Animes {
        return animeGateway.getAnimes(page)
    }
}