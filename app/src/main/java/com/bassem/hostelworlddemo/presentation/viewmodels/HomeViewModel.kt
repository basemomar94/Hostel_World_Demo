package com.bassem.hostelworlddemo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassem.hostelworlddemo.data.models.Result
import com.bassem.hostelworlddemo.domain.usecases.FetchPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchPropertiesUseCase: FetchPropertiesUseCase) :
    ViewModel() {
    private var _propertiesList = MutableStateFlow<Result<Any?>?>(null)
    val propertiesList: Flow<Result<Any?>> get() = _propertiesList.filterNotNull()

    init {
        fetchProperties()
    }

    private fun fetchProperties() = viewModelScope.launch {
        fetchPropertiesUseCase().collect { result ->
            _propertiesList.value = result
        }
    }
}
