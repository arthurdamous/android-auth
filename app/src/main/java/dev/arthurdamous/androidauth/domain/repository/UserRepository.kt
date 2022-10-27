package dev.arthurdamous.androidauth.domain.repository

import retrofit2.http.Body

interface UserRepository {

    suspend fun loginUser(email: String, password: String): Boolean
}