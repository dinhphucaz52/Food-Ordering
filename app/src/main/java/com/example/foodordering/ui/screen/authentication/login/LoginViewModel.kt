package com.example.foodordering.ui.screen.authentication.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodordering.di.AppModule
import com.example.foodordering.util.AppResource
import com.example.foodordering.util.AuthHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

//@HiltViewModel
class LoginViewModel
//@Inject constructor(private val repository: AuthRepository, )
    : ViewModel() {

    private val repository = AppModule.provideAuthRepository()

    var username = mutableStateOf("dinh.phuc.17.5.25@gmail.com")
    var password = mutableStateOf("00000000")
    var loginSuccess = mutableStateOf(false)
    var errorMessage = mutableStateOf("")

    fun login() {
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