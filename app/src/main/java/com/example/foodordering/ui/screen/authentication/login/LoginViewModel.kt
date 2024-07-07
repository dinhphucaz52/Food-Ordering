package com.example.foodordering.ui.screen.authentication.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodordering.AppModule
import com.example.foodordering.util.AppResource
import com.example.foodordering.util.AuthHelper
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val repository = AppModule.provideAuthenticationRepository()

    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var loginSuccess = mutableStateOf(false)
    var errorMessage = mutableStateOf("")

    fun onLoginClicked() {
        viewModelScope.launch {
            if (AuthHelper.validateEmail(username.value) && AuthHelper.validatePassword(password.value)) {
                return@launch
            }
            val result = repository.login(username.value, password.value)
            if (result is AppResource.Success) {
                loginSuccess.value = true
            } else {
                errorMessage.value = (result as AppResource.Error).error
            }
        }
    }
}