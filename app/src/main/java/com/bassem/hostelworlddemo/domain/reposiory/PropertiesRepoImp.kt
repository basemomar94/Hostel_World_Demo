package com.bassem.hostelworlddemo.domain.reposiory

import android.content.Context
import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.Result
import com.bassem.hostelworlddemo.domain.utils.getExceptionMessage
import com.bassem.hostelworlddemo.domain.utils.trackApiCall
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PropertiesRepoImp @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext private val context: Context
) : PropertiesRepo {
    override suspend fun getProperties() = flow {
        emit(Result.Loading)
        try {
            val result = trackApiCall(
                action = "get-properties",
                apiCall = { apiService.getProperties() },
                service = apiService
            )
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Fail(context.getExceptionMessage(e)))
        }
    }

}