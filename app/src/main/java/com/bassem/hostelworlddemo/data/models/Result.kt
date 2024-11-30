package com.bassem.hostelworlddemo.data.models


sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Fail(val reasons: String) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}




