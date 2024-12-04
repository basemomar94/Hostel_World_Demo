package com.bassem.hostelworlddemo.domain.utils

import com.bassem.hostelworlddemo.BaseTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ApiTrackerExtensionTest : BaseTest() {

    @Test
    fun `measureDuration should measure duration and return result`() = runBlocking {
        val expectedResult = "mock result!"
        val fakeAction: suspend () -> String = {
            delay(100)
            expectedResult
        }

        val (result, duration) = measureDuration { fakeAction() }

        assertEquals(expectedResult, result)
        assertTrue(duration >= 100)
        assertTrue(duration < 200)
    }

}