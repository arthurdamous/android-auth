package dev.arthurdamous.androidauth.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.arthurdamous.androidauth.data.remote.UserApi
import dev.arthurdamous.androidauth.data.repository.UserRepositoryImpl
import dev.arthurdamous.androidauth.domain.repository.UserRepository
import dev.arthurdamous.androidauth.domain.use_case.GetNotes
import dev.arthurdamous.androidauth.domain.use_case.LoginUser
import dev.arthurdamous.androidauth.domain.use_case.UserUseCases
import dev.arthurdamous.androidauth.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val token =
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzNTgzNDc4ZTM4MjcwZTY5MmE4MTg3YiIsImlhdCI6MTY2NzMzMDM4NH0.kzwlWZNEMtpB5A7XCI_qQZ6ClAQfOTPxgdvXkTk0j7M"
                val modifiedRequest = it.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                it.proceed(modifiedRequest)
            }
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    @Provides
    @Singleton
    fun providesUserApi(
        okHttpClient: OkHttpClient
    ): UserApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun providesUserRepository(
        userApi: UserApi
    ): UserRepository {
        return UserRepositoryImpl(userApi)
    }

    @Provides
    @Singleton
    fun providesUserUseCases(
        repository: UserRepository
    ): UserUseCases {
        return UserUseCases(
            loginUser = LoginUser(repository),
            getNotes = GetNotes(repository)
        )
    }

}