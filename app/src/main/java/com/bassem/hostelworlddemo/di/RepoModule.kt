package com.bassem.hostelworlddemo.di

import com.bassem.hostelworlddemo.domain.reposiory.ExchangeRepo
import com.bassem.hostelworlddemo.domain.reposiory.ExchangeRepoImp
import com.bassem.hostelworlddemo.domain.reposiory.PropertiesRepo
import com.bassem.hostelworlddemo.domain.reposiory.PropertiesRepoImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun providePropertiesRepo(impl: PropertiesRepoImp): PropertiesRepo

    @Binds
    abstract fun provideExchangeRatesRepo(impl: ExchangeRepoImp): ExchangeRepo
}