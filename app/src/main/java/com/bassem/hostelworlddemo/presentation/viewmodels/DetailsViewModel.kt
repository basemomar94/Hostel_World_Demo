package com.bassem.hostelworlddemo.presentation.viewmodels

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
    private var _propertiesList = MutableStateFlow<Result<Any?>?>(null)
    val propertiesList: Flow<Result<Any?>> get() = _propertiesList.filterNotNull()

    init {
        fetchExchangeRates()
    }

     private fun fetchExchangeRates() = viewModelScope.launch {
         fetchExchangeRateRatesUseCase().collect { resutlt ->
            _propertiesList.value =resutlt
        }
    }

}