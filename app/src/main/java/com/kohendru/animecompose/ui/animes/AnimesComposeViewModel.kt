package com.kohendru.animecompose.ui.animes

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kohendru.animecompose.domain.entities.Anime
import com.kohendru.animecompose.domain.usecases.GetAnimesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AnimesComposeViewModel @Inject constructor(
    private val getAnimesUseCase: GetAnimesUseCase
) : ViewModel() {
    @FlowPreview
    fun getPagedAnimes(): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 50),
            pagingSourceFactory = {
                AnimesComposePagingSource(
                    getAnimesUseCase = getAnimesUseCase
                )
            }
        ).flow
    }
}