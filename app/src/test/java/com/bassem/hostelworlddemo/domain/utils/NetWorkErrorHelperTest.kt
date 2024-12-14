package com.bassem.hostelworlddemo.domain.utils

import android.content.Context
import com.bassem.hostelworlddemo.BaseTest
import com.bassem.hostelworlddemo.R
import com.google.gson.JsonParseException
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.IOException
import java.sql.SQLException

class NetWorkErrorHelperTest : BaseTest() {

    @ParameterizedTest
    @MethodSource("provideExceptions")
    fun `test handling errors with expected message`(exception: Exception, expectedMessageResId: Int) = runTest {

        val context = mockk<Context>(relaxed = true)

        every { context.getString(expectedMessageResId) } returns "Expected message"

        val actualMessage = getExceptionMessage(exception)

        Assertions.assertEquals("Expected message", actualMessage)
    }

    companion object {
        @JvmStatic
        fun provideExceptions() = listOf(
            Arguments.of(IOException(), R.string.net_work_error),
            Arguments.of(SQLException(), R.string.local_parsing_error),
            Arguments.of(JsonParseException(""), R.string.remote_parsing_error),
            Arguments.of(NullPointerException(), R.string.unexpected_error)
        )
    }
}