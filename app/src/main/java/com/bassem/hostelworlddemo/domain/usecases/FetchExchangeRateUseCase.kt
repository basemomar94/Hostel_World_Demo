package com.bassem.hostelworlddemo.domain.usecases

import com.bassem.hostelworlddemo.domain.reposiory.ExchangeRepo
import javax.inject.Inject

class FetchExchangeRateUseCase @Inject constructor(private val repo: ExchangeRepo) {

    suspend operator fun invoke() = repo.getExchangeRates()
}