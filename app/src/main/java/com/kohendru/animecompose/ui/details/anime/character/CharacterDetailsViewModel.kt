package com.kohendru.animecompose.ui.details.anime.character

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kohendru.animecompose.R
import com.kohendru.animecompose.domain.entities.characterDetails.Character
import com.kohendru.animecompose.domain.usecases.GetCharacterDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel() {
    val malId: Int = savedStateHandle.get("mal_id")!!

    var characterDetails: Character? by mutableStateOf(null)
    var isLoading: Boolean by mutableStateOf(false)
    var errorMessage: Int? by mutableStateOf(null)

    init {
        getCharacterDetails(malId)
    }

    private fun getCharacterDetails(malId: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                characterDetails = getCharacterDetailsUseCase(malId)
            } catch (e: Exception) {
                Timber.e(e)
                errorMessage = R.string.get_character_details_error
            }
            isLoading = false
        }
    }
}