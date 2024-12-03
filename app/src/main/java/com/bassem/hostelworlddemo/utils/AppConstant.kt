package com.bassem.hostelworlddemo.utils

import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.data.models.RatingBreakdown

object AppConstant {

    private val cairoHotel =
        Property(
            id = 2,
            name = "Cairo Hotel",
            isNew = true,
            isFeatured = false,
            isPromoted = false,
            ratingBreakdown = RatingBreakdown(average = 97),
            lowestPricePerNight = LowestPricePerNight("USD", "50"),
        )
    private val sphinxHotel =
        Property(
            id = 0,
            name = "Sphinx Hotel",
            isNew = false,
            isFeatured = false,
            isPromoted = true,
            ratingBreakdown = RatingBreakdown(
                average = 83,
                security = 90,
                clean = 58,
                location = 99
            ),
            lowestPricePerNight = LowestPricePerNight("EUR", "88"),
        )

    internal val propertyList = listOf(cairoHotel, sphinxHotel)
}