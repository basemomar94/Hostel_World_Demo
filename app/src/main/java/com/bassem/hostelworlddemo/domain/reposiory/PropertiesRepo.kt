package com.bassem.hostelworlddemo.domain.reposiory

import kotlinx.coroutines.flow.Flow
import com.bassem.hostelworlddemo.data.models.Result
interface PropertiesRepo {

   suspend fun getProperties(): Flow<Result<Any?>>
}