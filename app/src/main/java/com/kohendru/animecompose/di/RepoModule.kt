package com.kohendru.animecompose.di

import com.kohendru.animecompose.data.source.AnimeRepository
import com.kohendru.animecompose.domain.gateways.AnimeGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideAnimeGateway(
        animeRepository: AnimeRepository
    ): AnimeGateway = animeRepository
}