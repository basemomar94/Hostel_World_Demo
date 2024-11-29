package com.bassem.hostelworlddemo.data.models

data class ResultData(
    val filterData: FilterData,
    val location: Location,
    val locationEn: LocationEn,
    val pagination: Pagination,
    val properties: List<Property>,
    val sortOrder: Any
)