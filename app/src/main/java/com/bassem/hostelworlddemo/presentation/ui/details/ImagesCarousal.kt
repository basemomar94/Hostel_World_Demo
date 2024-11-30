package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyImage

@Composable
fun ImagesCarousel(images: List<String>, modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxWidth()) {
        LazyRow (
            contentPadding = PaddingValues(dimensionResource(R.dimen.default_padding)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.default_padding))
        ) {
            items(images) { imageUrl ->
                PropertyImage(
                    imageUrl = imageUrl,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.details_image_height))
                )
            }
        }
    }
}



