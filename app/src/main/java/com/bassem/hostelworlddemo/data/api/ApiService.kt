package com.bassem.hostelworlddemo.data.api

import com.bassem.hostelworlddemo.data.models.ExchangeData
import com.bassem.hostelworlddemo.data.models.ResultData
import retrofit2.http.GET

interface ApiService {
    @GET("a1517b9da90dd6877385a65f324ffbc3/raw/058e83aa802907cb0032a15ca9054da563138541/properties.json")
    suspend fun getProperties(): ResultData

    @GET("16e87e40ca7b9650aa8e1b936f23e14e/raw/15efd901b57c2b66bf0201ee7aa9aa2edc6df779/rates.json")
    suspend fun getExchangeRates(): ExchangeData
}
