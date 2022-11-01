package dev.arthurdamous.androidauth.presentation.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.arthurdamous.androidauth.presentation.notes.components.NoteItem

@Composable
fun NotesScreen(
    viewModel: NotesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        val listOfNotes = state.listOfNotes
        LazyColumn() {
            items(listOfNotes.size) { i ->
                NoteItem(listOfNotes[i])
            }
        }

    }

}