package com.bassem.hostelworlddemo.domain.reposiory

import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.domain.utils.getExceptionMessage
import com.bassem.hostelworlddemo.utils.Logger
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExchangeRepoImp @Inject constructor(
    private val apiService: ApiService
) : ExchangeRepo {
    private val log = Logger("ExchangeRepoImp")

    override suspend fun getExchangeRates() = flow {
        emit(PropertyResult.Loading)
        try {
            val result = apiService.getExchangeRates()

            emit(PropertyResult.Success(result))
        } catch (e: Exception) {
            log.e("Exception is $e message is ${e.cause?.message}")
            emit(PropertyResult.Fail(getExceptionMessage(e)))
        }
    }


}