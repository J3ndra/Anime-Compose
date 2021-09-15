package com.kohendru.animecompose.data.source.remote

import com.kohendru.animecompose.data.source.remote.response.person.NetworkVoiceActingRole
import com.kohendru.animecompose.data.source.remote.response.person.PersonResponse
import com.kohendru.animecompose.domain.entities.person.Anime
import com.kohendru.animecompose.domain.entities.person.Character
import com.kohendru.animecompose.domain.entities.person.Person
import com.kohendru.animecompose.domain.entities.person.VoiceActingRole

fun PersonResponse.asPersonDetails() = Person(
    mal_id = malId,
    url = url,
    image_url = imageUrl,
    website_url = websiteUrl,
    name = name,
    given_name = givenName,
    family_name = familyName,
    alternate_names = alternateNames,
    birthday = birthday,
    member_favorites = memberFavorites,
    about = about,
    voice_acting_roles = voiceActingRoles?.map { it.asVoiceActorRole() },
    anime_staff_positions = animeStaffPositions,
    published_manga = publishedManga
)

fun NetworkVoiceActingRole.asVoiceActorRole() = VoiceActingRole(
    role = role,
    anime = asAnimeByVoiceActor(),
    character = asCharacterByVoiceActor()
)

fun NetworkVoiceActingRole.asAnimeByVoiceActor() = Anime (
    mal_id = anime?.malId,
    url = anime?.url,
    image_url = anime?.imageUrl,
    name = anime?.name
)

fun NetworkVoiceActingRole.asCharacterByVoiceActor() = Character(
    mal_id = character?.malId,
    url = character?.url,
    image_url = character?.imageUrl,
    name = character?.name
)