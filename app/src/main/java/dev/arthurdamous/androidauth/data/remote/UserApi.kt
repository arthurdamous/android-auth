package dev.arthurdamous.androidauth.data.remote

import dev.arthurdamous.androidauth.data.remote.dto.BodyDto
import dev.arthurdamous.androidauth.data.remote.dto.NotesDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("auth/login")
    suspend fun loginUser(
        @Body body: BodyDto
    ): Response<Void>

    @GET("notes")
    suspend fun getAllNotes(): NotesDto

}