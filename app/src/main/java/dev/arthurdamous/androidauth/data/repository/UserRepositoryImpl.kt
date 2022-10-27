package dev.arthurdamous.androidauth.data.repository

import dev.arthurdamous.androidauth.data.remote.UserApi
import dev.arthurdamous.androidauth.data.remote.dto.BodyDto
import dev.arthurdamous.androidauth.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {
    override suspend fun loginUser(email: String, password: String): Boolean {
        val request = userApi.loginUser(
            body = BodyDto(email, password)
        )
        return request.isSuccessful
    }
}