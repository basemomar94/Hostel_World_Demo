package com.bassem.hostelworlddemo.domain.utils


import com.bassem.hostelworlddemo.data.models.ErrorTypes
import com.google.gson.JsonParseException
import java.io.IOException
import java.sql.SQLException

fun getExceptionMessage(e: Exception) = when (e) {
    is IOException -> ErrorTypes.IoException
    is SQLException -> ErrorTypes.SqlException
    is JsonParseException -> ErrorTypes.JsonException
    else -> ErrorTypes.Generic(e.message)
}