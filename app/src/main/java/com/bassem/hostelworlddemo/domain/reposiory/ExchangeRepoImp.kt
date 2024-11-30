package com.bassem.hostelworlddemo.domain.reposiory

import android.content.Context
import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.Result
import com.bassem.hostelworlddemo.utils.Logger
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExchangeRepoImp @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext private val context: Context
) : ExchangeRepo {
    private val log = Logger("ExchangeRepoImp")

    override suspend fun getExchangeRates() = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(apiService.getExchangeRates()))
        } catch (e: Exception) {
            log.e("exception is $e message is ${e.cause?.message}")
            emit(Result.Fail(context.getExceptionMessage(e)))
        }
    }

}