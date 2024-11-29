package com.bassem.hostelworlddemo.data.models

data class LowestAveragePrivatePricePerNight(
    val currency: String,
    val original: String,
    val promotions: Promotions,
    val value: String
)