package com.bassem.hostelworlddemo.domain.usecase

import com.bassem.hostelworlddemo.BaseTest
import com.bassem.hostelworlddemo.domain.reposiory.PropertiesRepo
import com.bassem.hostelworlddemo.domain.usecases.FetchPropertiesUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FetchPropertiesUseCaseTest : BaseTest() {
    private val repo: PropertiesRepo = mockk(relaxed = true)
    private val useCase = FetchPropertiesUseCase(repo)

    @Test
    fun `invoke should call getProperties on repo`() = runBlocking {

        useCase()

        coVerify { repo.getProperties() }

    }
}