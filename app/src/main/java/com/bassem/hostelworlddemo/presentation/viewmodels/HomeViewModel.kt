package com.bassem.hostelworlddemo.presentation.viewmodels

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bassem.hostelworlddemo.data.models.PropertyResult
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
    private var _propertiesList = MutableStateFlow<PropertyResult<Any?>?>(null)
    val propertiesList: Flow<PropertyResult<Any?>> get() = _propertiesList.filterNotNull()

    init {
        fetchProperties()
    }

    @VisibleForTesting
    fun fetchProperties() = viewModelScope.launch {
        fetchPropertiesUseCase().collect { result ->
            _propertiesList.value = result
        }
    }
}
