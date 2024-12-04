package com.bassem.hostelworlddemo.presentation.home

import com.bassem.hostelworlddemo.presentation.BaseComposeTest
import com.bassem.hostelworlddemo.presentation.ui.home.HomeList
import com.bassem.hostelworlddemo.presentation.utils.getRating
import org.junit.Test

class HomeListTest : BaseComposeTest() {

    private var clickedId: Int = -1

    override fun setUp() {
        super.setUp()
        composeTestRule.setContent {
            HomeList(propertyList) { clickedId = it.id }
        }
    }

    @Test
    fun test_all_properties_are_displayed() {
        propertyList.forEach { prop ->
            assertTextIsDisplayed(prop.name)
            assertTextIsDisplayed("${prop.overallRating?.overall.getRating()}")
        }
    }

    @Test
    fun test_property_click() {
        clickNodeWithText(propertyList[1].name)
        assert(sphinxHotel.id == clickedId)
    }
}