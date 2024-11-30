package com.bassem.hostelworlddemo.domain.reposiory

import android.content.Context
import com.bassem.hostelworlddemo.R
import com.google.gson.JsonParseException
import java.io.IOException
import java.sql.SQLException

fun Context.getExceptionMessage(e: Exception) = when (e) {
    is IOException -> getString(R.string.net_work_error)
    is SQLException -> getString(R.string.local_parsing_error)
    is JsonParseException -> getString(R.string.remote_parsing_error)
    else -> getString(R.string.unexpected_error)
}