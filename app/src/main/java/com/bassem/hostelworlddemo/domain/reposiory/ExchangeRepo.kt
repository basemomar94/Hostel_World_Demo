package com.bassem.hostelworlddemo.domain.reposiory

import com.bassem.hostelworlddemo.data.models.Result
import kotlinx.coroutines.flow.Flow

interface ExchangeRepo {

    suspend fun getExchangeRates(): Flow<Result<Any?>>
}