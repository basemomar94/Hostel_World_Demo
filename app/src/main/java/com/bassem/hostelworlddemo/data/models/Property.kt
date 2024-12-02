package com.bassem.hostelworlddemo.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Property(
    val district: District? = null,
    val freeCancellation: FreeCancellation? = null,
    val freeCancellationAvailable: Boolean = false,
    val id: Int = 0,
    val imagesGallery: List<ImagesGallery> = emptyList(),
    val isFeatured: Boolean = false,
    val isNew: Boolean = false,
    val isPromoted: Boolean = false,
    val lowestPricePerNight: LowestPricePerNight? = null,
    val name: String = "",
    val ratingBreakdown: RatingBreakdown? = null,
    val overview: String = "",
):Parcelable
