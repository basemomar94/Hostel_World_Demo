package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.presentation.ui.theme.gold

@Preview
@Composable
private fun RatingBarPreview() {
    StarRating(3.0, "clean")
}

@Composable
fun StarRating(rating: Double, label: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(vertical = dimensionResource(R.dimen.small_padding))) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            modifier = modifier.align(Alignment.CenterVertically).width(dimensionResource(R.dimen.text_width))
        )
        Spacer(modifier = modifier.width(dimensionResource(R.dimen.small_padding)))
        for (i in 1..10) {
            Icon(
                imageVector = if (i <= rating.toInt()) Icons.Filled.Star else Icons.TwoTone.Star,
                contentDescription = null,
                tint = gold,
                modifier = modifier.size(dimensionResource(R.dimen.icon_size_medium))
            )
        }
    }
}

