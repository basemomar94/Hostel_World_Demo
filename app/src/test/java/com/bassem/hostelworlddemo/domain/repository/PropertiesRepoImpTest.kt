package com.bassem.hostelworlddemo.domain.repository

import android.content.Context
import com.bassem.hostelworlddemo.BaseTest
import com.bassem.hostelworlddemo.data.api.ApiService
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.domain.reposiory.PropertiesRepoImp
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PropertiesRepoImpTest : BaseTest() {

    private lateinit var repoImp: PropertiesRepoImp
    private val apiService: ApiService = mockk(relaxed = true)
    private val context: Context = mockk(relaxed = true)

    override fun setup() {
        super.setup()
        repoImp = PropertiesRepoImp(apiService = apiService, context = context)
    }

    @Test
    fun `getting exchange rates should emmit loading then result`() = runTest {
        coEvery { apiService.getProperties() } returns propertiesResult
        val actualList = repoImp.getProperties().toList()
        Assertions.assertTrue(actualList[0] is PropertyResult.Loading)
        Assertions.assertTrue(actualList[1] is PropertyResult.Success)
        Assertions.assertTrue((actualList[1] as PropertyResult.Success).data == propertiesResult)
    }
}