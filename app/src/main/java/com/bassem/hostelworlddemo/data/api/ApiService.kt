package com.bassem.hostelworlddemo.data.api

import com.bassem.hostelworlddemo.data.models.ExchangeData
import com.bassem.hostelworlddemo.data.models.PropertiesResultData
import com.bassem.hostelworlddemo.data.utils.ApiConstants.EXCHANGE_END_POINT
import com.bassem.hostelworlddemo.data.utils.ApiConstants.PROPERTIES_END_POINT
import com.bassem.hostelworlddemo.data.utils.ApiConstants.STATS_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(PROPERTIES_END_POINT)
    suspend fun getProperties(): PropertiesResultData

    @GET(EXCHANGE_END_POINT)
    suspend fun getExchangeRates(): ExchangeData

    @GET(STATS_END_POINT)
    suspend fun sendStats(
        @Query("action") action: String,
        @Query("duration") duration: Long
    )
}
