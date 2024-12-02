package com.bassem.hostelworlddemo.presentation.home

import com.bassem.hostelworlddemo.presentation.BaseComposeTest
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyItem
import org.junit.Test

class PropertyItemTest : BaseComposeTest() {

    private var isPropertyClicked = false

    override fun setUp() {
        super.setUp()
        composeTestRule.setContent {
            PropertyItem(property = property, onCardClick = { isPropertyClicked = true })
        }
    }

    @Test
    fun test_item_display_property_name() {
        assertTextIsDisplayed(property.name)
    }

    @Test
    fun test_item_property_clicked() {
        clickNodeWithText(property.name)
        assert(isPropertyClicked)
    }


}