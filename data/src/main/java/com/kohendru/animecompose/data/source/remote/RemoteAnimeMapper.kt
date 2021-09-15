package com.kohendru.animecompose.data.source.remote

import com.kohendru.animecompose.data.source.remote.response.AnimesResponse
import com.kohendru.animecompose.data.source.remote.response.NetworkAnime
import com.kohendru.animecompose.data.source.remote.response.characterAndStaff.CharacterAndStaffResponse
import com.kohendru.animecompose.data.source.remote.response.characterAndStaff.NetworkCharacter
import com.kohendru.animecompose.data.source.remote.response.characterAndStaff.NetworkStaff
import com.kohendru.animecompose.data.source.remote.response.characterDetails.CharacterResponse
import com.kohendru.animecompose.data.source.remote.response.details.AnimeDetailsResponse
import com.kohendru.animecompose.data.source.remote.response.episodes.EpisodesResponse
import com.kohendru.animecompose.data.source.remote.response.episodes.NetworkEpisode
import com.kohendru.animecompose.domain.entities.Anime
import com.kohendru.animecompose.domain.entities.Animes
import com.kohendru.animecompose.domain.entities.characterAndStaff.Character
import com.kohendru.animecompose.domain.entities.characterAndStaff.CharactersAndStaff
import com.kohendru.animecompose.domain.entities.characterAndStaff.Staff
import com.kohendru.animecompose.domain.entities.characterAndStaff.VoiceActor
import com.kohendru.animecompose.domain.entities.details.*
import com.kohendru.animecompose.domain.entities.episodes.Episode
import com.kohendru.animecompose.domain.entities.episodes.Episodes


fun AnimesResponse.asAnimes() = Animes(
    animes = top.map { it.asAnime() }
)

fun NetworkAnime.asAnime() = Anime(
    mal_id = malId,
    episodes = episodes,
    image_url = imageUrl,
    members = members,
    rank = rank,
    score = score,
    title = title,
    type = type,
    url = url
)

fun AnimeDetailsResponse.asAnime(): Anime {
    return Anime(
        mal_id = malId,
        image_url = imageUrl,
        episodes = episodes,
        members = members,
        rank = rank,
        score = score,
        title = title,
        type = type,
        url = url
    )
}

fun AnimeDetailsResponse.asGenres(): List<Genre> {
    return genres.map {
        Genre(
            mal_id = it.malId,
            name = it.name,
            url = it.url
        )
    }?.toList() ?: emptyList()
}

fun AnimeDetailsResponse.asAnimeAdaption(): List<Adaptation> {
    return related.adaptation?.map {
        Adaptation(
            mal_id = it.malId,
            name = it.name,
            type = it.type,
            url = it.url

        )
    }?.toList() ?: emptyList()
}

fun AnimeDetailsResponse.asAnimeAired(): Aired {
    return Aired(
        string = aired?.string
    )
}

fun AnimeDetailsResponse.asAnimePrequel(): List<Prequel> {
    return related.prequel?.map {
        Prequel(
            mal_id = it.malId,
            name = it.name,
            type = it.type
        )
    }?.toList() ?: emptyList()
}

fun AnimeDetailsResponse.asAnimeSequel(): List<Sequel> {
    return related.sequel?.map {
        Sequel(
            mal_id = it.malId,
            name = it.name,
            type = it.type
        )
    }?.toList() ?: emptyList()
}

fun AnimeDetailsResponse.asAnimeLicensor(): List<Licensor> {
    return licensors.map {
        Licensor(
            mal_id = it.malId,
            name = it.name,
            type = it.type
        )
    }?.toList() ?: emptyList()
}

fun AnimeDetailsResponse.asAnimeProducer(): List<Producer> {
    return producers.map {
        Producer(
            mal_id = it.malId,
            name = it.name,
            type = it.type
        )
    }?.toList() ?: emptyList()
}

fun AnimeDetailsResponse.asAnimeStudio(): List<Studio> {
    return studios.map {
        Studio(
            mal_id = it.malId,
            name = it.name,
            type = it.type
        )
    }?.toList() ?: emptyList()
}

fun AnimeDetailsResponse.asAnimeRelated() = Related(
    adaptation = asAnimeAdaption(),
    prequel = asAnimePrequel(),
    sequel = asAnimeSequel()
)

fun EpisodesResponse.asEpisodes() = Episodes(
    episodes = episodes.map { it.asEpisode() }
)

fun NetworkEpisode.asEpisode(): Episode {
    return Episode(
        aired = aired,
        episode_id = episodeId,
        forum_url = forumUrl,
        title = title,
        title_japanese = titleJapanese,
        title_romanji = titleRomanji,
        video_url = videoUrl
    )
}

fun AnimeDetailsResponse.asAnimeDetails(): AnimeDetails {
    return AnimeDetails(
        anime = asAnime(),
        aired = asAnimeAired(),
        airing = airing,
        background = background,
        broadcast = broadcast,
        duration = duration,
        ending_themes = endingThemes,
        favorites = favorites,
        genres = asGenres(),
        image_url = imageUrl,
        licensors = asAnimeLicensor(),
        opening_themes = openingThemes,
        popularity = popularity,
        premiered = premiered,
        producers = asAnimeProducer(),
        rating = rating,
        related = asAnimeRelated(),
        scored_by = scoredBy,
        source = source,
        status = status,
        studios = asAnimeStudio(),
        synopsis = synopsis,
        title = title,
        title_english = titleEnglish,
        title_japanese = titleJapanese,
        title_synonyms = titleSynonyms,
        trailer_url = trailerUrl,
        url = url
    )
}

fun CharacterAndStaffResponse.asCharacterAndStaff() = CharactersAndStaff (
    characters = characters.map { it.asCharacter() },
    staff = staff.map { it.asStaff() }
)

fun NetworkStaff.asStaff() = Staff(
    image_url = imageUrl,
    mal_id = malId,
    name = name,
    positions = positions,
    url = url
)

fun NetworkCharacter.asCharacter() = Character(
    image_url = imageUrl,
    mal_id = malId,
    name = name,
    role = role,
    url = url,
    voice_actors = asVoiceActor()
)

fun NetworkCharacter.asVoiceActor(): List<VoiceActor> {
    return voiceActors.map {
        VoiceActor(
            image_url = it.imageUrl,
            language = it.language,
            mal_id = it.malId,
            name = it.name,
            url = it.url
        )
    }?.toList() ?: emptyList()
}