package com.example.foodordering.di

import com.example.foodordering.data.remote.ApiService
import com.example.foodordering.data.repository.AuthRepositoryImpl
import com.example.foodordering.data.repository.CustomerRepositoryImpl
import com.example.foodordering.domain.repository.AuthRepository
import com.example.foodordering.domain.repository.CustomerRepository
import com.example.foodordering.util.AppConstants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    class AuthorizationInterceptor(private val token: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val authenticatedRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
            return chain.proceed(authenticatedRequest)
        }
    }

    private const val TOKEN =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjI0OTI3MDY3MTIsImRhdGEiOnsiX2lkIjoiNjYzYTM5MDM0M2NmNjNhMjI3NDFjZjllIiwiZW1haWwiOiJkaW5oLnBodWMuMTcuNS4yNUBnbWFpbC5jb20iLCJwYXNzd29yZCI6IiQyYiQxMCRuamF5MHRxUFZRWDRLejkueWlYRzR1d3RESkc5c1VmQkxBdW5yazVPMGRLUzAxc0dmemh0QyIsIm5hbWUiOiJOZ3V54buFbiDEkMOsbmggUGjDumMiLCJwaG9uZSI6IjEyMzQ1Njc4OTEwIiwidXNlckdyb3VwIjowLCJyZWdpc3RlckRhdGUiOiIyMDI0LTA1LTA3VDE0OjIxOjU1LjkzNFoiLCJfX3YiOjB9LCJpYXQiOjE3MTUxMDY3MTJ9.x5zSg-IitDdYxhpPVlc26iF6k928Rpj7cgNJe30RHIo"

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(AppConstants.TIME_REQUEST_DEFAULT, TimeUnit.SECONDS)
            .readTimeout(AppConstants.TIME_REQUEST_DEFAULT, TimeUnit.SECONDS)
            .writeTimeout(AppConstants.TIME_REQUEST_DEFAULT, TimeUnit.SECONDS)
            .addInterceptor(AuthorizationInterceptor(TOKEN))
            .build()


        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return provideRetrofitClient().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository {
        val retrofitClient = provideRetrofitClient()
        val apiService = retrofitClient.create(ApiService::class.java)
        return AuthRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideCustomerRepository(): CustomerRepository {
        return CustomerRepositoryImpl(provideApiService())
    }

}