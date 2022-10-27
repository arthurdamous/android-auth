package dev.arthurdamous.androidauth.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.arthurdamous.androidauth.domain.use_case.UserUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state


    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.LoginUser -> {
                viewModelScope.launch {
                    val result = userUseCases.loginUser(event.email, event.password)
                    if (result) println("Usuário logado") else println("Usuário não encontrado")
                }
            }
            is MainEvent.OnChangeEmail -> {
                _state.value = state.value.copy(
                    email = event.text
                )
            }
            is MainEvent.OnChangePassword -> {
                _state.value = state.value.copy(
                    password = event.text
                )
            }
        }
    }
}