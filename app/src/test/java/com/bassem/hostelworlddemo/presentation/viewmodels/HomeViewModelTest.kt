package com.bassem.hostelworlddemo.presentation.viewmodels

import com.bassem.hostelworlddemo.BaseTest
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.domain.usecases.FetchPropertiesUseCase
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
class HomeViewModelTest : BaseTest() {

    private lateinit var homeViewModel: HomeViewModel
    private var fetchPropertiesUseCase: FetchPropertiesUseCase = mockk(relaxed = true)


    override fun setup() {
        super.setup()
        homeViewModel = HomeViewModel(fetchPropertiesUseCase)
    }

    @Test
    fun `fetch properties should emit loading first`() = runTest {
        val loading = PropertyResult.Loading
        coEvery { fetchPropertiesUseCase.invoke() } returns flowOf(loading)
        homeViewModel.fetchProperties()
        val emittedResult = homeViewModel.propertiesList.first()
        advanceUntilIdle()
        Assertions.assertEquals(loading, emittedResult)
    }

    @Test
    fun `fetch properties should emit success result`() = runTest {
        val propertyResult = PropertyResult.Success(propertiesResult)
        coEvery { fetchPropertiesUseCase.invoke() } returns flowOf(propertyResult)
        homeViewModel.fetchProperties()
        val emittedResult = homeViewModel.propertiesList.first()
        advanceUntilIdle()
        Assertions.assertEquals(propertyResult, emittedResult)
    }
}