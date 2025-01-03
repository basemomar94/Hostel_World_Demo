package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.ExchangeData
import com.bassem.hostelworlddemo.data.models.FreeCancellation
import com.bassem.hostelworlddemo.data.models.ImagesGallery
import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.data.models.Rates
import com.bassem.hostelworlddemo.data.models.RatingBreakdown
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyName
import com.bassem.hostelworlddemo.presentation.ui.shared.ErrorTextCompose
import com.bassem.hostelworlddemo.presentation.ui.shared.LoadingIndicator
import com.bassem.hostelworlddemo.presentation.ui.shared.PropertyLabelWithIcon
import com.bassem.hostelworlddemo.presentation.utils.convert
import com.bassem.hostelworlddemo.presentation.utils.getCity
import com.bassem.hostelworlddemo.presentation.utils.getErrorMessage
import com.bassem.hostelworlddemo.presentation.utils.getImagesListUrls
import com.bassem.hostelworlddemo.presentation.viewmodels.DetailsViewModel

@Preview
@Composable
private fun DetailsScreenPreview() {
    DetailsCompose(
        propertyName = "Alex Hostel",
        images = listOf(),
        overview = "overview test test test test  hotel alex",
        rating = RatingBreakdown(),
        price = null,
        address = "Cairo",
        rates = Rates(EUR = 1.0, USD = 0.9, GBP = 1.2),
        cancellation = FreeCancellation(description = "test cancel", label = "cancel"),
        latitude = 5.5,
        longitude = 6.1
    )
}

@Composable
fun DetailsScreen(
    property: Property,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val propertyResult by viewModel.exchangeRatesList.collectAsState(initial = PropertyResult.Loading)
    val context = LocalContext.current
    when (propertyResult) {
        is PropertyResult.Loading -> {
            LoadingIndicator()
        }

        is PropertyResult.Success -> {
            val successPropertyResult =
                (propertyResult as PropertyResult.Success<Any?>).data as? ExchangeData
            if (successPropertyResult != null) {
                with(property) {
                    DetailsCompose(
                        propertyName = name,
                        images = imagesGallery,
                        overview = overview,
                        rating = ratingBreakdown,
                        price = lowestPricePerNight,
                        address = district.getCity(),
                        modifier = modifier,
                        rates = successPropertyResult.rates,
                        cancellation = freeCancellation,
                        latitude = latitude,
                        longitude = longitude
                    )

                }

            } else {
                ErrorTextCompose(message = stringResource(R.string.unexpected_data_format))
            }

        }

        is PropertyResult.Fail -> {
            ErrorTextCompose(message = context.getErrorMessage((propertyResult as PropertyResult.Fail).errorTypes))
        }
    }

}

@Composable
fun DetailsCompose(
    propertyName: String,
    images: List<ImagesGallery>,
    overview: String,
    rating: RatingBreakdown?,
    price: LowestPricePerNight?,
    address: String,
    rates: Rates,
    latitude: Double?,
    longitude: Double?,
    cancellation: FreeCancellation?,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    var selectedCurrency by remember { mutableStateOf("EUR") }
    val convertedPrice = price?.value.convert(selectedCurrency, rates)
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

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.default_padding)))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            PropertyLabelWithIcon(
                text = "$selectedCurrency $convertedPrice",
                drawable = R.drawable.price
            )
            PropertyLabelWithIcon(
                text = address,
                drawable = R.drawable.location
            )
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            CurrencyChoice(
                selectedCurrency = selectedCurrency,
                onCurrencyChange = { selectedCurrency = it },
                modifier = Modifier.padding(vertical = dimensionResource(R.dimen.default_padding))
            )
            OpenInMapsButton(latitude = latitude, longitude = longitude, modifier = Modifier)
        }

        if (rating != null) {
            RatingContainer(rating)
        }

        DetailsContainer(
            overview = overview,
            cancellation = cancellation,
        )
    }


}