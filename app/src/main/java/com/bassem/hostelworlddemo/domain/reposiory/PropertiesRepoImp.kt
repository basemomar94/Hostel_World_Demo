package com.bassem.hostelworlddemo.domain.reposiory

import android.content.Context
import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.PropertyResult
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
        emit(PropertyResult.Loading)
        try {
            val result = trackApiCall(
                action = "get-properties",
                apiCall = { apiService.getProperties() },
                service = apiService
            )
            emit(PropertyResult.Success(result))
        } catch (e: Exception) {
            emit(PropertyResult.Fail(context.getExceptionMessage(e)))
        }
    }

}