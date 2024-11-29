package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R


@Preview
@Composable
private fun PropertyPricePreview(){
    PropertyPrice("4000")
}

@Composable
fun PropertyPrice(lowestPrice: String,modifier: Modifier=Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(start = dimensionResource(R.dimen.default_padding))
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = stringResource(R.string.price_icon),
            tint = MaterialTheme.colorScheme.primary,
            modifier = modifier.size(dimensionResource(R.dimen.icon_size))
        )
        Text(
            text = "€$lowestPrice",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = modifier.padding(start = dimensionResource(R.dimen.small_padding))
        )
    }
}