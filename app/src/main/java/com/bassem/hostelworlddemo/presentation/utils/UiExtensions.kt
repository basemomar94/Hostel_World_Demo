package com.bassem.hostelworlddemo.presentation.utils

import com.bassem.hostelworlddemo.data.models.District
import com.bassem.hostelworlddemo.data.models.ImagesGallery
import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.Rates
import com.bassem.hostelworlddemo.data.models.RatingBreakdown
import com.bassem.hostelworlddemo.presentation.ui.theme.green
import com.bassem.hostelworlddemo.presentation.ui.theme.red
import com.bassem.hostelworlddemo.presentation.ui.theme.yellow
import java.math.BigDecimal
import java.math.RoundingMode

fun List<ImagesGallery>?.getRandomImageUrl(): String? {
    if (this?.isEmpty() == true) return ""
    val randomImage = this?.random()
    return randomImage?.composeImageUrl()
}

fun List<ImagesGallery>.getImagesListUrls() = this.map { it.composeImageUrl() }

fun ImagesGallery.composeImageUrl(): String {
    val prefix = prefix
    val suffix = suffix
    return "https://$prefix$suffix"
}

fun RatingBreakdown?.getRating(): Double {
    if (this == null) return -1.0
    return average / 10.0
}

fun getRatingColor(rating: Double) = when {
    rating >= 8.0 -> green
    rating >= 5.0 -> yellow
    else -> red
}

fun LowestPricePerNight?.getPrice(): String {
    if (this == null || currency == null || value == null) return "N/A"
    return "$currency $value"
}

fun District?.getCity(): String {
    if (this == null || name == null) return "N/A"
    return name
}

fun String?.convert(currency: String, rates: Rates): String {
    val price = this?.toDoubleOrNull() ?: return "N/A"
    return when (currency) {
        "EUR" -> price.roundToTwoDecimals()
        "USD" -> (price * rates.USD).roundToTwoDecimals()
        "GBP" -> (price * rates.GBP).roundToTwoDecimals()
        else -> "N/A"
    }
}

fun Double.roundToTwoDecimals() = BigDecimal(this).setScale(2, RoundingMode.HALF_UP).toString()
