package com.example.foodordering.ui.screen.customer.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodordering.di.AppModule
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = AppModule.provideCustomerRepository()

    fun getCart() {
        viewModelScope.launch {
            repository.addCart("62b72b165e4e6e6e3c6a81e7")
        }
    }

}