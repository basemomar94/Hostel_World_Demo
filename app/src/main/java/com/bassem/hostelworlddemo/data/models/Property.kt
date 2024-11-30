package com.bassem.hostelworlddemo.data.models

data class Property(
    val address1: String,
    val address2: String,
    val district: District,
    val facilities: List<Facility>,
    val freeCancellation: FreeCancellation,
    val freeCancellationAvailable: Boolean,
    val id: Int,
    val imagesGallery: List<ImagesGallery>,
    val isFeatured: Boolean,
    val isNew: Boolean,
    val isPromoted: Boolean,
    val latitude: Double,
    val longitude: Double,
    val lowestPricePerNight: LowestPricePerNight,
    val name: String,
    val overallRating: OverallRating,
    val ratingBreakdown: RatingBreakdown,
    val overview: String,
    val starRating: Int,
    val type: String,
    val veryPopular: Boolean
)