package com.kohendru.animecompose.domain.usecases

import com.kohendru.animecompose.domain.entities.characterAndStaff.CharactersAndStaff
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import javax.inject.Inject

class GetAnimeCharactersAndStaffUseCase @Inject constructor(
    private val animeGateway: AnimeGateway
) {

    suspend operator fun invoke(malId: Int): CharactersAndStaff {
        return animeGateway.getAnimeCharacterAndStaff(malId)
    }
}