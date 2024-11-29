package com.bassem.hostelworlddemo.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.bassem.hostelworlddemo.domain.usecases.FetchPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchPropertiesUseCase: FetchPropertiesUseCase) :
    ViewModel() {

    suspend fun fetchProperties() = fetchPropertiesUseCase()

}