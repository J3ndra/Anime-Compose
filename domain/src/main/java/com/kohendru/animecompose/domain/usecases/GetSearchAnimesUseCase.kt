package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.search.Search
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetSearchAnimesUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

    suspend operator fun invoke(q: String, page: Int): Search {
        return animeGateway.getSearchAnimes(q, page)
    }
}