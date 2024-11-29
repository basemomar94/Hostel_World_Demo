package com.bassem.hostelworlddemo.data.models

data class Promotion(
    val discount: Int,
    val id: Int,
    val name: String,
    val stack: Boolean,
    val type: String
)