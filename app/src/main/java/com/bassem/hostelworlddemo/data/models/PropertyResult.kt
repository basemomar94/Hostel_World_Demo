package com.bassem.hostelworlddemo.data.models


sealed class PropertyResult<out T> {
    data class Success<out T>(val data: T) : PropertyResult<T>()
    data class Fail(val reasons: String) : PropertyResult<Nothing>()
    data object Loading : PropertyResult<Nothing>()
}




