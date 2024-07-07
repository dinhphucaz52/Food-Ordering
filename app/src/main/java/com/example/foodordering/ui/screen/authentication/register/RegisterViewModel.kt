package com.example.foodordering.ui.screen.authentication.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodordering.AppModule
import com.example.foodordering.util.AppResource
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val repository = AppModule.provideAuthenticationRepository()

    val username = mutableStateOf("")
    val password = mutableStateOf("")
    val phoneNumber = mutableStateOf("")
    val email = mutableStateOf("")
    val registerSuccess = mutableStateOf(false)

    private var errorMessage: String = ""

    fun getErrorMessage(): String {
        return errorMessage
    }

    fun register() {
        viewModelScope.launch {

            val result =
                repository.register(username.value, email.value, password.value, phoneNumber.value)

            if (result is AppResource.Success) {
                registerSuccess.value = true
            } else {
                errorMessage = (result as AppResource.Error).error
            }

        }
    }

}