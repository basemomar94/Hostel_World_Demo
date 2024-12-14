package com.bassem.hostelworlddemo.domain.reposiory

import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.domain.utils.getExceptionMessage
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PropertiesRepoImp @Inject constructor(
    private val apiService: ApiService
) : PropertiesRepo {
    override suspend fun getProperties() = flow {
        emit(PropertyResult.Loading)
        try {
            val result = apiService.getProperties()
            emit(PropertyResult.Success(result))
        } catch (e: Exception) {
            emit(PropertyResult.Fail(getExceptionMessage(e)))
        }
    }

}