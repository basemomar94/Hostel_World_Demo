package com.bassem.hostelworlddemo.presentation.viewmodels

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassem.hostelworlddemo.data.models.Result
import com.bassem.hostelworlddemo.domain.usecases.FetchExchangeRateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(private val fetchExchangeRateRatesUseCase: FetchExchangeRateUseCase) :
    ViewModel() {
    private var _exchangeRatesList = MutableStateFlow<Result<Any?>?>(null)
    val exchangeRatesList: Flow<Result<Any?>> get() = _exchangeRatesList.filterNotNull()

    init {
        fetchExchangeRates()
    }

    @VisibleForTesting
    fun fetchExchangeRates() = viewModelScope.launch {
        fetchExchangeRateRatesUseCase().collect { result ->
            _exchangeRatesList.value = result
        }
    }

}