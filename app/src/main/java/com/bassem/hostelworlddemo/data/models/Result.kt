package com.bassem.hostelworlddemo.data.models


sealed class Result<T> {
    data object Loading : Result<Any?>()
    data class Success(val breedItems: ResultData) : Result<Any?>()
    data class Fail(val reasons: String) : Result<Any?>()
}
