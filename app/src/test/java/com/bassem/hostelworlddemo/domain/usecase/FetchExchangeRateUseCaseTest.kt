package com.bassem.hostelworlddemo.domain.usecase

import com.bassem.hostelworlddemo.BaseTest
import com.bassem.hostelworlddemo.domain.reposiory.ExchangeRepo
import com.bassem.hostelworlddemo.domain.usecases.FetchExchangeRateUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FetchExchangeRateUseCaseTest : BaseTest() {
    private val repo: ExchangeRepo = mockk(relaxed = true)
    private val useCase = FetchExchangeRateUseCase(repo)

    @Test
    fun `invoke should call getExchangeRates on repo`() = runBlocking {

        useCase()

        coVerify { repo.getExchangeRates() }

    }
}