package com.bassem.hostelworlddemo.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImagesGallery(
    val prefix: String,
    val suffix: String
):Parcelable