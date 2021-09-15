package com.kohendru.animecompose.ui.animes

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kohendru.animecompose.domain.entities.Anime
import com.kohendru.animecompose.domain.usecases.GetAnimesUseCase
import timber.log.Timber

private const val STARTING_PAGE_INDEX = 1

class AnimesComposePagingSource(
    private val getAnimesUseCase: GetAnimesUseCase
) : PagingSource<Int, Anime>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = getAnimesUseCase(page)

            LoadResult.Page(
                data = response.animes,
                prevKey = if(page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if(page == 0) null else page + 1
            )
        } catch (e: Exception) {
            Timber.e(e)
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition
    }
}