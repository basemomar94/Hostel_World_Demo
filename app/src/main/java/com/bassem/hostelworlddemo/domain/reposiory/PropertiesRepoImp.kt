package com.bassem.hostelworlddemo.domain.reposiory

import android.content.Context
import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.Result
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
            emit(Result.Success(apiService.getProperties()))
        } catch (e: Exception) {
            emit(Result.Fail(context.getExceptionMessage(e)))
        }
    }

}