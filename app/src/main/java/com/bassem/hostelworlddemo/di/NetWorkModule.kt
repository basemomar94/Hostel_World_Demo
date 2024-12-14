package com.bassem.hostelworlddemo.di

import com.bassem.hostelworlddemo.data.api.ApiConstants.BASE_URL
import com.bassem.hostelworlddemo.data.api.ApiInterceptor
import com.bassem.hostelworlddemo.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetWorkModule {

    @Singleton
    @Provides
    fun provideInterceptor(apiServiceProvider: Provider<ApiService>,) = ApiInterceptor(apiServiceProvider, Dispatchers.IO)

    @Singleton
    @Provides
    fun provideOkHttpClient(apiInterceptor: ApiInterceptor) =
        OkHttpClient.Builder().addInterceptor(apiInterceptor).build()

    @Singleton
    @Provides
    fun provideNetWorkService(client: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}