package com.bassem.hostelworlddemo.data.models

sealed class ErrorTypes {
    data object IoException : ErrorTypes()
    data object SqlException : ErrorTypes()
    data object JsonException : ErrorTypes()
    data class Generic(val message: String?) : ErrorTypes()

}