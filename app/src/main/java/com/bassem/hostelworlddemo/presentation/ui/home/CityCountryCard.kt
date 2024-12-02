package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R

@Preview
@Composable
fun CityCountryCardPreview() {
    CityCountryCard("Cairo", "Egypt")
}


@Composable
fun CityCountryCard(city: String, country: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.padding(dimensionResource(R.dimen.default_padding)),
        shadowElevation = dimensionResource(R.dimen.small_padding),
        shape = RoundedCornerShape(dimensionResource(R.dimen.default_padding)),
        color = colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.default_padding))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(imageVector = Icons.Default.LocationOn, stringResource(R.string.location))
            Text(
                text = city,
                style = typography.headlineMedium,
                color = colorScheme.primary
            )
            Text(
                text = country,
                style = typography.bodyMedium,
                color = colorScheme.onSurfaceVariant
            )
        }
    }
}
