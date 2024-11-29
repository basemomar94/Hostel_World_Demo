package com.bassem.hostelworlddemo.presentation.utils

import com.bassem.hostelworlddemo.data.models.ImagesGallery

fun List<ImagesGallery>.getImageUrl(): String {
    val randomImage = random()
    val prefix = randomImage.prefix
    val suffix = randomImage.suffix
    return "https://$prefix$suffix"
}