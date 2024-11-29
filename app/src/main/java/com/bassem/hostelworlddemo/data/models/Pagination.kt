package com.bassem.hostelworlddemo.data.models

data class Pagination(
    val next: String,
    val numberOfPages: Int,
    val prev: String,
    val totalNumberOfItems: Int
)