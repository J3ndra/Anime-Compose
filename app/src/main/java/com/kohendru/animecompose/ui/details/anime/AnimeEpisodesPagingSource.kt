package com.kohendru.animecompose.ui.details.anime

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kohendru.animecompose.domain.entities.episodes.Episode
import com.kohendru.animecompose.domain.usecases.GetAnimeEpisodesUseCase
import timber.log.Timber
import java.lang.Exception

private const val STARTING_PAGE_INDEX = 1

//class AnimeEpisodesPagingSource (
//    private val getAnimeEpisodesUseCase: GetAnimeEpisodesUseCase
//) : PagingSource<Int, Episode>() {
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
//        val page = params.key ?: STARTING_PAGE_INDEX
//        val malId = params.key
//
//        return try {
//            val response = getAnimeEpisodesUseCase(page, malId)
//
//            LoadResult.Page(
//                data = response.episodes,
//                prevKey = if(page == STARTING_PAGE_INDEX) null else page - 1,
//                nextKey = if(page == 0) null else page + 1
//            )
//        } catch (e: Exception) {
//            Timber.e(e)
//            LoadResult.Error(e)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Episode>): Int? {
//        return state.anchorPosition
//    }
//}