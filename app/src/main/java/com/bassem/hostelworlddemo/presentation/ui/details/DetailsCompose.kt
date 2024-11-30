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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.ExchangeData
import com.bassem.hostelworlddemo.data.models.ImagesGallery
import com.bassem.hostelworlddemo.data.models.LowestPricePerNight
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.data.models.Rates
import com.bassem.hostelworlddemo.data.models.Result
import com.bassem.hostelworlddemo.presentation.ui.home.ErrorTextCompose
import com.bassem.hostelworlddemo.presentation.ui.home.LoadingIndicator
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyLabelWithIcon
import com.bassem.hostelworlddemo.presentation.ui.home.PropertyName
import com.bassem.hostelworlddemo.presentation.utils.convert
import com.bassem.hostelworlddemo.presentation.utils.getCity
import com.bassem.hostelworlddemo.presentation.utils.getImagesListUrls
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
        price = null,
        address = "Cairo",
        rates = Rates(EUR = 1.0, USD = 0.9, GBP = 1.2)
    )
}

@Composable
fun DetailsScreen(
    property: Property,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val result by viewModel.exchangeRatesList.collectAsState(initial = Result.Loading)
    when (result) {
        is Result.Loading -> {
            LoadingIndicator()
        }

        is Result.Success -> {
            val successResult = (result as Result.Success<Any?>).data as? ExchangeData
            if (successResult != null) {
                with(property) {
                    DetailsCompose(
                        propertyName = name,
                        images = imagesGallery,
                        overview = overview,
                        rating = ratingBreakdown.getRating(),
                        price = lowestPricePerNight,
                        address = district.getCity(),
                        modifier = modifier,
                        rates = successResult.rates
                    )

                }

            } else {
                ErrorTextCompose(message = stringResource(R.string.unexpected_data_format))
            }

        }

        is Result.Fail -> {
            ErrorTextCompose(message = (result as Result.Fail).reasons)
        }
    }

}

@Composable
fun DetailsCompose(
    propertyName: String,
    images: List<ImagesGallery>,
    overview: String,
    rating: Double,
    price: LowestPricePerNight?,
    address: String,
    rates: Rates,
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
        if (rating != -1.0) {
            StarRating(
                rating,
            )
        }
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
        CurrencyChoice(
            selectedCurrency = selectedCurrency,
            onCurrencyChange = { selectedCurrency = it },
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.default_padding))
        )

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