package com.bassem.hostelworlddemo.data.models

data class Property(
    val district: District? = null,
    val facilities: List<Facility> = emptyList(),
    val freeCancellation: FreeCancellation? = null,
    val freeCancellationAvailable: Boolean = false,
    val id: Int = 0,
    val imagesGallery: List<ImagesGallery> = emptyList(),
    val isFeatured: Boolean = false,
    val isNew: Boolean = false,
    val isPromoted: Boolean = false,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val lowestPricePerNight: LowestPricePerNight? = null,
    val name: String = "",
    val overallRating: OverallRating? = null,
    val ratingBreakdown: RatingBreakdown? = null,
    val overview: String = "",
)
