package dev.arthurdamous.androidauth.domain.use_case

import dev.arthurdamous.androidauth.domain.model.Note
import dev.arthurdamous.androidauth.domain.repository.UserRepository

class GetNotes(private val repository: UserRepository) {


    suspend operator fun invoke(): List<Note> {
        return repository.getAllNotes()
    }
}