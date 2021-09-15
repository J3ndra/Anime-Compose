package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.person.Person
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetPersonDetailsUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {
    suspend operator fun invoke(malId: Int): Person {
        return animeGateway.getPersonDetails(malId)
    }
}