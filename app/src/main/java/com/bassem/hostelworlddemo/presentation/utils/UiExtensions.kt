package com.bassem.hostelworlddemo.presentation.utils

import com.bassem.hostelworlddemo.data.models.ImagesGallery
import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.OriginalLowestAverageDormPricePerNight
import com.bassem.hostelworlddemo.data.models.RatingBreakdown
import com.bassem.hostelworlddemo.presentation.ui.theme.green
import com.bassem.hostelworlddemo.presentation.ui.theme.red
import com.bassem.hostelworlddemo.presentation.ui.theme.yellow

fun List<ImagesGallery>.getRandomImageUrl(): String {
    val randomImage = random()
    return randomImage.composeImageUrl()
}

fun List<ImagesGallery>.getImagesListUrls() = this.map { it.composeImageUrl() }

fun ImagesGallery.composeImageUrl(): String {
    val prefix = prefix
    val suffix = suffix
    return "https://$prefix$suffix"
}

fun RatingBreakdown.getRating(): Double = average / 10.0

fun getRatingColor(rating: Double) = when {
    rating >= 8.0 -> green
    rating >= 5.0 -> yellow
    else -> red
}

fun LowestPricePerNight.getPrice() = "$currency $value"