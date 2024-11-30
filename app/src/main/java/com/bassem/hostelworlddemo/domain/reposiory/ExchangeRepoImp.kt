package com.bassem.hostelworlddemo.domain.reposiory

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.Result
import com.google.gson.JsonParseException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.sql.SQLException
import javax.inject.Inject

class ExchangeRepoImp @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext private val context: Context
) : ExchangeRepo {

    override suspend fun getExchangeRates() = flow {
        emit(Result.Loading)
        try {
            emit(Result.Success(apiService.getExchangeRates()))
        } catch (e: Exception) {
            emit(Result.Fail(context.getExceptionMessage(e)))
        }
    }

}