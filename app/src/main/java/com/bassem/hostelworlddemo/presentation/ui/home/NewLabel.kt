package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R

@Preview
@Composable
fun NewLabelPreview() {
    NewLabel()
}

@Composable
fun NewLabel(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(dimensionResource(R.dimen.default_padding))
    ) {
        Text(
            text = stringResource(R.string._new),
            color = Color.White,
            style = MaterialTheme.typography.labelLarge,
            modifier = modifier.background(
                    color = Color.Red.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))
                )
                .padding(
                    horizontal = dimensionResource(R.dimen.small_padding),
                    vertical = dimensionResource(R.dimen.default_padding)
                )
        )
    }
}
