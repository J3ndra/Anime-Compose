package com.kohendru.animecompose.ui.details.anime

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kohendru.animecompose.R
import com.kohendru.animecompose.domain.entities.characterAndStaff.CharactersAndStaff
import com.kohendru.animecompose.domain.entities.details.AnimeDetails
import com.kohendru.animecompose.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAnimeDetailsUseCase: GetAnimeDetailsUseCase,
    private val getAnimeCharactersAndStaffUseCase: GetAnimeCharactersAndStaffUseCase,
) : ViewModel() {

    val malId: Int = savedStateHandle.get("mal_id")!!

    var animeDetails: AnimeDetails? by mutableStateOf(null)
    var animeCharactersAndStaff: CharactersAndStaff? by mutableStateOf(null)

    var isLoading: Boolean by mutableStateOf(false)
    var errorMessage: Int? by mutableStateOf(null)

    init {
        getAnimeDetails(malId)
        getAnimeCharactersAndStaff(malId)
    }

    private fun getAnimeDetails(malId: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                animeDetails = getAnimeDetailsUseCase(malId)
            } catch (e: Exception) {
                Timber.e(e)
                errorMessage = R.string.get_anime_details_error_message
            }
            isLoading = false
        }
    }

    private fun getAnimeCharactersAndStaff(malId: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                animeCharactersAndStaff = getAnimeCharactersAndStaffUseCase(malId)
            } catch (e: Exception) {
                Timber.e(e)
                errorMessage = R.string.get_anime_characters_error_message
            }
            isLoading = false
        }
    }
}
