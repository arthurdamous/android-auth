package dev.arthurdamous.androidauth.domain.repository

import dev.arthurdamous.androidauth.domain.model.Note

interface UserRepository {

    suspend fun loginUser(email: String, password: String): Boolean

    suspend fun getAllNotes(): List<Note>
}