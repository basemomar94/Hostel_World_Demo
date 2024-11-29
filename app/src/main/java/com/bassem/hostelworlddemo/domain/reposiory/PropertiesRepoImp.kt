package com.bassem.hostelworlddemo.domain.reposiory

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.Result
import com.google.gson.JsonParseException
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.sql.SQLException
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
            emit(Result.Fail(getExceptionMessage(e)))
        }
    }

    @VisibleForTesting
    fun getExceptionMessage(e: Exception) = when (e) {
        is IOException -> context.getString(R.string.net_work_error)
        is SQLException -> context.getString(R.string.local_parsing_error)
        is JsonParseException -> context.getString(R.string.remote_parsing_error)
        else -> context.getString(R.string.unexpected_error)
    }

}