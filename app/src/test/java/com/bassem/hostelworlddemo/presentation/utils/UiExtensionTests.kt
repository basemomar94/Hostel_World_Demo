package com.bassem.hostelworlddemo.presentation.utils

import com.bassem.hostelworlddemo.BaseTest
import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.Rates
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class UiExtensionTests : BaseTest() {

    @ParameterizedTest
    @CsvSource(
        "EUR, 100.0, 100.00",
        "USD, 100.0, 120.00",
        "GBP, 100.0, 90.00"
    )
    fun `convert returns correct value based on currency`(
        currency: String,
        input: Double,
        expected: String
    ) {
        val rates = Rates(USD = 1.2, GBP = 0.9)
        val result = input.toString().convert(currency, rates)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "3.14159, 3.14",
        "2.71828, 2.72",
        "1.0, 1.00"
    )
    fun `roundToTwoDecimals rounds numbers correctly`(input: Double, expected: String) {
        val result = input.roundToTwoDecimals()
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("providePriceData")
    fun `getPrice returns correct format or N_A`(
        lowestPrice: LowestPricePerNight?,
        expected: String
    ) {
        val result = lowestPrice.getPrice()
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun providePriceData() = listOf(
            Arguments.of(LowestPricePerNight("USD", "42.50"), "USD 42.50"),
            Arguments.of(null, "N/A")
        )
    }
}
