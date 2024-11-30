package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.ImagesGallery
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyLabelWithIcon
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyName
import com.bassem.hostelworlddemo.presentation.utils.getCity
import com.bassem.hostelworlddemo.presentation.utils.getImagesListUrls
import com.bassem.hostelworlddemo.presentation.utils.getPrice
import com.bassem.hostelworlddemo.presentation.utils.getRating
import com.bassem.hostelworlddemo.presentation.viewmodels.DetailsViewModel

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsCompose(
        propertyName = "Alex Hostel",
        images = listOf(),
        overview = "overview test test test test dadad daadad adadd",
        rating = 7.8,
        price = "500",
        address = "Cairo"
    )
}

@Composable
fun DetailsScreen(property: Property, modifier: Modifier = Modifier) {
    with(property) {
        DetailsCompose(
            propertyName = name,
            images = imagesGallery,
            overview = overview,
            rating = ratingBreakdown.getRating(),
            price = lowestPricePerNight.getPrice(),
            address = district.getCity(),
            modifier = modifier
        )

    }

}

@Composable
fun DetailsCompose(
    propertyName: String,
    images: List<ImagesGallery>,
    overview: String,
    rating: Double,
    price: String,
    address: String,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.default_padding))
            .verticalScroll(scrollState)
    ) {
        ImagesCarousel(
            images = images.getImagesListUrls(),
        )
        PropertyName(
            name = propertyName,
        )
        if (rating != -1.0) {
            StarRating(
                rating,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            PropertyLabelWithIcon(
                text = price,
                drawable = R.drawable.price
            )
            PropertyLabelWithIcon(
                text = address,
                drawable = R.drawable.location
            )
        }

        Text(
            text = overview,
            style = MaterialTheme.typography.labelMedium,
        )
        Text(
            text = address,
            style = MaterialTheme.typography.labelMedium,
        )
    }


}