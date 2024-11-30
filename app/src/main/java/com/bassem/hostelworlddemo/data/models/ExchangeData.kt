package com.bassem.hostelworlddemo.data.models

data class ExchangeData(
    val base: String = "",
    val date: String = "",
    val historical: Boolean = false,
    val rates: Rates,
    val success: Boolean = false,
    val timestamp: Int = 0
)