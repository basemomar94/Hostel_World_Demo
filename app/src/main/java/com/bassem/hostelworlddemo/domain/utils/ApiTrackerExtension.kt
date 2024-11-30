package com.bassem.hostelworlddemo.domain.utils

import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.utils.Logger

suspend fun <T> trackApiCall(
    action: String,
    apiCall: suspend () -> T,
    service: ApiService
): T {
    val log = Logger("sendingApisStats")
    val (result, duration) = measureDuration { apiCall() }
    try {
        service.sendStats(action = action, duration = duration)
        log.i("action = $action duration = $duration")
    } catch (e: Exception) {
        log.e("Failed to send stats: ${e.message}")
    }
    return result
}

suspend fun <T> measureDuration(action: suspend () -> T): Pair<T, Long> {
    val startTime = System.currentTimeMillis()
    val result = action()
    val duration = System.currentTimeMillis() - startTime
    return result to duration
}
