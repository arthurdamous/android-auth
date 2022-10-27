package dev.arthurdamous.androidauth.domain.use_case

import dev.arthurdamous.androidauth.domain.repository.UserRepository

class LoginUser(
    private val repository: UserRepository
) {

    suspend operator fun invoke(email: String, password: String): Boolean {
        return repository.loginUser(email, password)
    }
}