package com.bassem.hostelworlddemo.data.models

data class RatingBreakdown(
    val average: Int = -1,
    val clean: Int,
    val facilities: Int,
    val `fun`: Int,
    val location: Int,
    val ratingsCount: Int,
    val security: Int,
    val staff: Int,
    val value: Int
)