package dev.arthurdamous.androidauth.presentation

sealed class MainEvent {
    data class LoginUser(val email: String, val password: String) : MainEvent()
    data class OnChangeEmail(val text: String) : MainEvent()
    data class OnChangePassword(val text: String) : MainEvent()
}
