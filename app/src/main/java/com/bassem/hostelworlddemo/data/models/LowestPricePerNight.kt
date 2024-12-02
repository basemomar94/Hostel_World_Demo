package com.bassem.hostelworlddemo.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LowestPricePerNight(
    val currency: String? = null,
    val value: String? = null
): Parcelable