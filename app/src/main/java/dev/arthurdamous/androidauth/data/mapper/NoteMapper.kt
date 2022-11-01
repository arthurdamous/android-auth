package dev.arthurdamous.androidauth.data.mapper

import dev.arthurdamous.androidauth.data.remote.dto.RemoteNote
import dev.arthurdamous.androidauth.domain.model.Note

fun RemoteNote.toNote(): Note {
    return Note(
        _id, title, description, created, modified
    )
}