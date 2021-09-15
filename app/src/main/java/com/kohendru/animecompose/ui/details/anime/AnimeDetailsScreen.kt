package com.kohendru.animecompose.ui.details.anime

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kohendru.animecompose.R
import com.kohendru.animecompose.domain.entities.characterAndStaff.Character
import com.kohendru.animecompose.network.openMalUrl
import com.kohendru.animecompose.ui.common.ConnectivityStatus
import com.kohendru.animecompose.ui.common.LoadingBox
import com.kohendru.animecompose.ui.common.MessageBox
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
@Composable
fun AnimeDetailsScreen(
    viewModel: AnimeDetailsViewModel = hiltViewModel(),
    openCharacterDetails: (character: Character) -> Unit,
    upPressed: () -> Unit
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    if (viewModel.isLoading) {
        LoadingBox()
    } else {
        if (viewModel.errorMessage != null) {
            MessageBox(
                modifier = Modifier.fillMaxSize(),
                messageResId = viewModel.errorMessage!!,
            )
        } else {
            Scaffold(
                topBar = {
                    val title = viewModel.animeDetails?.title
                    AnimeDetailsTopBar(
                        title = title ?: "",
                        upPressed = upPressed,
                        url = viewModel.animeDetails?.url!!
                    )
                }
            ) {
                Column(
                    Modifier.verticalScroll(scrollState)
                ) {
                    ConnectivityStatus()
                    viewModel.animeDetails?.let { animeDetails ->

                        // Anime Poster
                        AnimeInfoPosterRow(animeDetails = animeDetails)
                        AnimeInfoRating(animeDetails = animeDetails)

                        // Anime Synopsis
                        if (animeDetails.synopsis != null) {
                            AnimeInfoHeader(title = stringResource(R.string.synopsis))
                            Text(
                                text = "${animeDetails.synopsis}",
                                textAlign = TextAlign.Justify,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp),
                                style = subtitleTextStyle
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        viewModel.animeCharactersAndStaff?.let { animeCharacterAndStaff ->

                            // Anime Characters
                            AnimeInfoHeader(title = stringResource(R.string.characters))
                            AnimeCharacterCarousel(
                                character = animeCharacterAndStaff.characters,
                                onItemClick = { openCharacterDetails(it) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(240.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            // Anime Staff
                            AnimeInfoHeader(title = stringResource(R.string.staff))
                            StaffCarousel(
                                staff = animeCharacterAndStaff.staff,
                                onItemClick = { openUrl -> openMalUrl(openUrl, context) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                            )
                        }

                        // Anime Opening Themes
                        if (animeDetails.opening_themes != null) {
                            AnimeInfoHeader(title = stringResource(R.string.opening_themes))

                            animeDetails.opening_themes!!.forEach {
                                Row(
                                    modifier = Modifier
                                        .padding(PaddingValues(start = 16.dp, end = 16.dp, bottom = 4.dp))
                                ) {
                                    Text(it)
                                }
                            }
                        }

                        // Anime Ending Themes
                        if (animeDetails.ending_themes != null) {
                            AnimeInfoHeader(title = stringResource(R.string.ending_themes))

                            animeDetails.ending_themes!!.forEach {
                                Row(
                                    modifier = Modifier
                                        .padding(PaddingValues(start = 16.dp, end = 16.dp, bottom = 4.dp))
                                ) {
                                    Text(it)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }
            }
        }
    }
}