package com.bassem.hostelworlddemo.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.data.models.RatingBreakdown
import org.junit.Before
import org.junit.Rule

abstract class BaseComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    internal val cairoHotel =
        Property(
            id = 2,
            name = "Cairo Hotel",
            isNew = true,
            isFeatured = false,
            isPromoted = false,
            ratingBreakdown = RatingBreakdown(average = 97),
            lowestPricePerNight = LowestPricePerNight("USD", "50"),
        )
    internal val sphinxHotel =
        Property(
            id = 0,
            name = "Sphinx Hotel",
            isNew = true,
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

    @Before
    open fun setUp() {

    }

    fun assertTextIsDisplayed(text: String) {
        composeTestRule.onNodeWithText(text).assertIsDisplayed()
    }

    fun assertTextIsNotDisplayed(text: String) {
        composeTestRule.onNodeWithText(text).assertIsNotDisplayed()
    }

    fun assertContentDescriptionIsDisplayed(contentDescription: String) {
        composeTestRule.onNodeWithContentDescription(contentDescription).assertExists()

    }

    fun clickNodeWithContentDescription(contentDescription: String) {
        composeTestRule.onNodeWithContentDescription(contentDescription).performClick()
    }

    fun clickNodeWithText(text: String) {
        composeTestRule.onNodeWithText(text).performClick()
    }
}