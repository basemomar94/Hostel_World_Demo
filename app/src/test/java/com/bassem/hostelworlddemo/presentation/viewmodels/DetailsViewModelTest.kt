package com.bassem.hostelworlddemo.presentation.viewmodels

import com.bassem.hostelworlddemo.BaseTest
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.domain.usecases.FetchExchangeRateUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailsViewModelTest : BaseTest() {

    private lateinit var detailsViewModel: DetailsViewModel
    private var fetchExchangeRateUseCase: FetchExchangeRateUseCase = mockk(relaxed = true)


    override fun setup() {
        super.setup()
        detailsViewModel = DetailsViewModel(fetchExchangeRateUseCase)
    }

    @Test
    fun `fetch properties should emit loading first`() = runTest {
        val loading = PropertyResult.Loading
        coEvery { fetchExchangeRateUseCase() } returns flowOf(loading)
        detailsViewModel.fetchExchangeRates()
        val emittedResult = detailsViewModel.exchangeRatesList.first()
        advanceUntilIdle()
        Assertions.assertEquals(loading, emittedResult)
    }

    @Test
    fun `fetch properties should emit success result`() = runTest {
        val propertyResult = PropertyResult.Success(ratesResult)
        coEvery { fetchExchangeRateUseCase() } returns flowOf(propertyResult)
        detailsViewModel.fetchExchangeRates()
        val emittedResult = detailsViewModel.exchangeRatesList.first()
        advanceUntilIdle()
        Assertions.assertEquals(propertyResult, emittedResult)
    }
}