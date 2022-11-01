package dev.arthurdamous.androidauth.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.arthurdamous.androidauth.domain.use_case.UserUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    init {
        getListOfNotes()
    }

    private fun getListOfNotes() {
        viewModelScope.launch {
            val list = userUseCases.getNotes()
            if (list.isNotEmpty()) {
                _state.value = state.value.copy(
                    listOfNotes = list
                )
            }
        }
    }

}