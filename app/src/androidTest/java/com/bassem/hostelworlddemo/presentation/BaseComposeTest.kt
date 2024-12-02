package com.bassem.hostelworlddemo.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.Property
import org.junit.Before
import org.junit.Rule

abstract class BaseComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    internal val property =
        Property(
            name = "Cairo Hotel",
            isNew = true,
            isFeatured = false,
            isPromoted = true,
            lowestPricePerNight = LowestPricePerNight("USD", "50"),
        )

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