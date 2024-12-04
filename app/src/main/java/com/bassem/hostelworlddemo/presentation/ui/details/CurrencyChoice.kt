package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R

@Preview
@Composable
private fun CurrencyChoicePreview() {
    CurrencyChoice("EUR", {})
}

@Composable
fun CurrencyChoice(
    selectedCurrency: String,
    onCurrencyChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        listOf("EUR", "USD", "GBP").forEach { currency ->
            FilterChip(
                selected = currency == selectedCurrency,
                onClick = { onCurrencyChange(currency) },
                label = { Text(currency) },
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.default_padding)),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    }
}

