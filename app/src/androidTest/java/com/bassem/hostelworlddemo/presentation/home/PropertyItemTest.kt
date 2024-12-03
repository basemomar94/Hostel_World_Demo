package com.bassem.hostelworlddemo.presentation.home

import com.bassem.hostelworlddemo.presentation.BaseComposeTest
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyItem
import org.junit.Test

class PropertyItemTest : BaseComposeTest() {

    private var isPropertyClicked = false

    override fun setUp() {
        super.setUp()
        composeTestRule.setContent {
            PropertyItem(property = cairoHotel, onCardClick = { isPropertyClicked = true })
        }
    }

    @Test
    fun test_item_display_property_name() {
        assertTextIsDisplayed(cairoHotel.name)
    }

    @Test
    fun test_item_display_property_rating() {
        assertTextIsDisplayed("9.7")
    }

    @Test
    fun test_item_display_property_new() {
        assertTextIsDisplayed("NEW")
    }


    @Test
    fun test_item_property_clicked() {
        clickNodeWithText(cairoHotel.name)
        assert(isPropertyClicked)
    }


}