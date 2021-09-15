package com.kohendru.animecompose.ui.animes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kohendru.animecompose.R
import com.kohendru.animecompose.ui.common.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun AnimesComposeScreen(
    viewModel: AnimesComposeViewModel = hiltViewModel(),
    openAnimeDetails: (malId: Int) -> Unit,
) {
    Scaffold(
        topBar = {
            AnimesComposeTopBar()
        }
    ) {
        val lazyPagingItems = viewModel.getPagedAnimes().collectAsLazyPagingItems()

        Column {
            ConnectivityStatus()
            LazyColumn {
                items(lazyPagingItems) { item ->
                    if (item != null) {
                        AnimeItem(
                            anime = item,
                            onAnimeClick = { openAnimeDetails(it) }
                        )
                    }
                }

                lazyPagingItems.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item {
                                PagingLoadingView(modifier = Modifier.fillParentMaxSize())
                            }
                        }

                        loadState.append is LoadState.Loading -> {
                            item {
                                PagingLoadingItem()
                            }
                        }

                        loadState.refresh is LoadState.Error -> {
                            val state = lazyPagingItems.loadState.refresh as LoadState.Error
                            item {
                                PagingErrorMessage(
                                    modifier = Modifier.fillMaxSize(),
                                    message = state.error.localizedMessage ?: stringResource(R.string.generic_error_message),
                                    onRetryClick = { retry() }
                                )
                            }
                        }

                        loadState.append is LoadState.Error -> {
                            val state = lazyPagingItems.loadState.append as LoadState.Error
                            item {
                                PagingErrorItem(
                                    message = state.error.localizedMessage ?: stringResource(R.string.generic_error_message),
                                    onRetryClick = { retry() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}