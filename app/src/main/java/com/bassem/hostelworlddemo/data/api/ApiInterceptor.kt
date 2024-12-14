package com.bassem.hostelworlddemo.data.api

import com.bassem.hostelworlddemo.data.utils.ApiConstants.STATS_END_POINT
import com.bassem.hostelworlddemo.data.utils.getActionName
import com.bassem.hostelworlddemo.utils.Logger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Provider


class ApiInterceptor @Inject constructor(
    private val apiServiceProvider: Provider<ApiService>,
    private val dispatcher: CoroutineDispatcher,
) : Interceptor {

    private val log = Logger("ApiInterceptor")
    private val job = SupervisorJob()
    private val scope = CoroutineScope(dispatcher + job)

    override fun intercept(chain: Interceptor.Chain): Response {
        val startTime = System.currentTimeMillis()
        val request = chain.request()
        val requestEndPoint = request.url.toString()
        log.i("current end point $requestEndPoint")
        if (requestEndPoint.contains(STATS_END_POINT)) {
            log.i("stats request not sending stats for it")
            return chain.proceed(request)
        }

        val response = try {
            chain.proceed(request)
        } catch (e: Exception) {
            log.e("Failed to proceed with request: ${e.message}")
            throw e
        }

        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        val action = requestEndPoint.getActionName()

        scope.launch {
            try {
                apiServiceProvider.get()
                    .sendStats(action = action, duration = duration)

                log.i("Stats sent successfully: action=$action, duration=$duration")

            } catch (e: Exception) {
                log.e("Failed to send stats: ${e.message}")
            }
        }

        return response
    }
}
