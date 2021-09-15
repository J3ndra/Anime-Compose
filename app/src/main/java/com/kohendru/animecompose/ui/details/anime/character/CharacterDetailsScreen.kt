package com.kohendru.animecompose.ui.details.anime.character

import androidx.compose.foundation.layout.*
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
import com.kohendru.animecompose.network.openMalUrl
import com.kohendru.animecompose.ui.common.LoadingBox
import com.kohendru.animecompose.ui.common.MessageBox
import com.kohendru.animecompose.ui.details.anime.AnimeInfoHeader

@Composable
fun CharacterDetailsScreen(
    upPressed: () -> Unit,
    viewModel: CharacterDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = { CharacterDetailsTopBar(upPressed = upPressed) }
    ) {
        if (viewModel.isLoading) {
            LoadingBox()
        } else {
            if (viewModel.errorMessage != null) {
                MessageBox(
                    modifier = Modifier.fillMaxSize(),
                    messageResId = viewModel.errorMessage!!,
                )
            } else {
                viewModel.characterDetails?.let { character ->
                    Column(
                        modifier = Modifier.verticalScroll(scrollState)
                    ) {
                        CharacterInfoAvatarRow(
                            character = character,
                            openUrl = { openUrl -> openMalUrl(openUrl, context) }
                        )

                        if (character.about.isNullOrEmpty().not()) {
                            AnimeInfoHeader(stringResource(R.string.about))
                            Text(
                                text = character.about!!,
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }

                        // VOICE ACTOR
                        if (character.voice_actors.isNullOrEmpty().not()) {
                            AnimeInfoHeader(title = stringResource(R.string.voice_actor))
                            VoiceActorCarousel(
                                voiceActor = character.voice_actors!!,
                                onItemClick = { openUrl -> openMalUrl(openUrl, context) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}