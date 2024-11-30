package com.bassem.hostelworlddemo.data.models

data class ExchangeData(
    val base: String,
    val date: String,
    val historical: Boolean,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)