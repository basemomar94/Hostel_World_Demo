package com.bassem.hostelworlddemo.presentation.shared

import androidx.compose.ui.graphics.Color
import com.bassem.hostelworlddemo.presentation.BaseComposeTest
import com.bassem.hostelworlddemo.presentation.ui.home.RatingLabel
import org.junit.Test

class RatingLabelTest : BaseComposeTest() {

    @Test
    fun test_when_rating_8_or_above_label_is_green() {
        composeTestRule.setContent {
            RatingLabel(8.0)
        }
        assertColorOnNodeWithText("8.0", Color.Green)
    }

    @Test
    fun test_when_rating_5_or_above_label_is_yellow() {
        composeTestRule.setContent {
            RatingLabel(5.2)
        }
        assertColorOnNodeWithText("5.2", Color.Yellow)
    }

    @Test
    fun test_when_rating_less_than_5_label_is_red() {
        composeTestRule.setContent {
            RatingLabel(3.1)
        }
        assertColorOnNodeWithText("3.1", Color.Red)
    }
}