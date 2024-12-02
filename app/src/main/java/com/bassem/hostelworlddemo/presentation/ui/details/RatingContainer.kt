package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.RatingBreakdown
import com.bassem.hostelworlddemo.presentation.utils.getRating

@Preview
@Composable
private fun RatingContainerPreview() {
    RatingContainer(
        RatingBreakdown(
            clean = 55,
            facilities = 25,
            location = 5,
            staff = 17,
            security = 80,
        )
    )
}

@Composable
fun RatingContainer(rating: RatingBreakdown) {
    Card(modifier = Modifier.padding(dimensionResource(R.dimen.small_padding)).fillMaxWidth()) {
        Column(modifier = Modifier.padding(
            dimensionResource(R.dimen.default_padding)
        )) {
            with(rating) {
                StarRating(label = stringResource(R.string.clean), rating = clean.getRating())
                StarRating(label = stringResource(R.string.security), rating = security.getRating())
                StarRating(label = stringResource(R.string.staff), rating = staff.getRating())
                StarRating(label = stringResource(R.string.location), rating = location.getRating())
            }
        }
    }

}