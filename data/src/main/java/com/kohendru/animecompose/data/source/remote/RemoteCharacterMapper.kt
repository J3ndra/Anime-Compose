package com.kohendru.animecompose.data.source.remote

import com.kohendru.animecompose.data.source.remote.response.characterDetails.CharacterResponse
import com.kohendru.animecompose.data.source.remote.response.characterDetails.NetworkAnimeography
import com.kohendru.animecompose.data.source.remote.response.characterDetails.NetworkMangaography
import com.kohendru.animecompose.data.source.remote.response.characterDetails.NetworkVoiceActor
import com.kohendru.animecompose.domain.entities.characterDetails.Animeography
import com.kohendru.animecompose.domain.entities.characterDetails.Character
import com.kohendru.animecompose.domain.entities.characterDetails.Mangaography
import com.kohendru.animecompose.domain.entities.characterDetails.VoiceActor

fun CharacterResponse.asCharacterDetails() = Character(
    mal_id = malId,
    url = url,
    name = name,
    name_kanji = nameKanji,
    nicknames = nicknames,
    about = about,
    member_favorites = memberFavorites,
    image_url = imageUrl,
    animeography = animeography?.map { it.asCharacterAnimeography() },
    mangaography = mangaography?.map { it.asCharacterMangaography() },
    voice_actors = voiceActors?.map { it.asCharacterVoiceActor() }
)

fun NetworkAnimeography.asCharacterAnimeography() = Animeography(
    mal_id = malId,
    name = name,
    url = url,
    image_url = imageUrl,
    role = role
)

fun NetworkMangaography.asCharacterMangaography() = Mangaography(
    mal_id = malId,
    name = name,
    url = url,
    image_url = imageUrl,
    role = role
)

fun NetworkVoiceActor.asCharacterVoiceActor() = VoiceActor(
    mal_id = malId,
    name = name,
    url = url,
    image_url = imageUrl,
    language = language
)