package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.characterDetails.Character
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

    suspend operator fun invoke(malId: Int): Character {
        return animeGateway.getCharacterDetails(malId)
    }
}