package com.bassem.hostelworlddemo.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OverallRating(
    val overall: Int
):Parcelable