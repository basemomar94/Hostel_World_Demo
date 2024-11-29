package com.bassem.hostelworlddemo.di

import com.bassem.hostelworlddemo.domain.reposiory.PropertiesRepo
import com.bassem.hostelworlddemo.domain.usecases.FetchPropertiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideFetchPropertiesUseCase(
        propertiesRepo: PropertiesRepo
    ): FetchPropertiesUseCase {
        return FetchPropertiesUseCase(propertiesRepo)
    }
}
