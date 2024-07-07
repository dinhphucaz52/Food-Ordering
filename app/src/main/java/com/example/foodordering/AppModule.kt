package com.example.foodordering

import com.example.foodordering.data.remote.ApiService
import com.example.foodordering.data.remote.RetrofitClient
import com.example.foodordering.data.repository.AuthRepositoryImpl
import com.example.foodordering.domain.repository.AuthRepository

object AppModule {

    private val authRepositoryImpl by lazy {
        AuthRepositoryImpl()
    }

    private val retrofitClient by lazy {
        RetrofitClient()
    }

    fun provideAuthenticationRepository(): AuthRepository {
        return authRepositoryImpl
    }

    fun provideApiService(): ApiService {
        return retrofitClient.getApiService()
    }

}