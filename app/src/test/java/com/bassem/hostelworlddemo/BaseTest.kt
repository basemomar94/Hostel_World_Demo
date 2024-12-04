package com.bassem.hostelworlddemo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.bassem.hostelworlddemo.data.models.ExchangeData
import com.bassem.hostelworlddemo.data.models.Rates
import com.bassem.hostelworlddemo.data.models.PropertiesResultData
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestResult
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

@OptIn(ExperimentalCoroutinesApi::class)
open class BaseTest {

    protected val propertiesResult = PropertiesResultData(location = null, properties = listOf())
    protected val ratesResult = ExchangeData(Rates(EUR = 1.0, USD = .9, GBP = 1.2))

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = TestResult



    @BeforeEach
    open fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterEach
    open fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

}