package com.bassem.hostelworlddemo.domain.reposiory

import kotlinx.coroutines.flow.Flow
import com.bassem.hostelworlddemo.data.models.PropertyResult
interface PropertiesRepo {

   suspend fun getProperties(): Flow<PropertyResult<Any?>>
}