package com.bassem.hostelworlddemo.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FreeCancellation(
    val description: String,
    val label: String
):Parcelable