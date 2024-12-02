package com.bassem.hostelworlddemo.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingBreakdown(
    val average: Int = -1,
    val clean: Int= -1,
    val facilities: Int= -1,
    val location: Int= -1,
    val ratingsCount: Int= -1,
    val security: Int= -1,
    val staff: Int= -1,
    val value: Int= -1,
): Parcelable