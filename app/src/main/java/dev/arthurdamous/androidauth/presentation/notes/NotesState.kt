package dev.arthurdamous.androidauth.presentation.notes

import dev.arthurdamous.androidauth.domain.model.Note

data class NotesState(
    val listOfNotes: List<Note> = emptyList(),
    val isLoading: Boolean = false
)