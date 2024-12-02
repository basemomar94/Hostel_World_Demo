package com.bassem.hostelworlddemo.domain.usecases

import com.bassem.hostelworlddemo.domain.reposiory.PropertiesRepo
import javax.inject.Inject

class FetchPropertiesUseCase @Inject constructor(private val repo: PropertiesRepo) {

    suspend operator fun invoke() = repo.getProperties()
}