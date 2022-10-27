package dev.arthurdamous.androidauth.data.remote

import dev.arthurdamous.androidauth.data.remote.dto.BodyDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("auth/login")
    suspend fun loginUser(
        @Body body: BodyDto
    ): Response<Void>
}