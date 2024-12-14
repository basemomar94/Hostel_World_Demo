package com.bassem.hostelworlddemo.domain.reposiory

import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.domain.reposiory.RepoConstants.ACTION_PROPERTIES
import com.bassem.hostelworlddemo.domain.utils.getExceptionMessage
import com.bassem.hostelworlddemo.domain.utils.trackApiCall
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PropertiesRepoImp @Inject constructor(
    private val apiService: ApiService
) : PropertiesRepo {
    override suspend fun getProperties() = flow {
        emit(PropertyResult.Loading)
        try {
            val result = trackApiCall(
                action = ACTION_PROPERTIES,
                apiCall = { apiService.getProperties() },
                service = apiService
            )
            emit(PropertyResult.Success(result))
        } catch (e: Exception) {
            emit(PropertyResult.Fail(getExceptionMessage(e)))
        }
    }

}