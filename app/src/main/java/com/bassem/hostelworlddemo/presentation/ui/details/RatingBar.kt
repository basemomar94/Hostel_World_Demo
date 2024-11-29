package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.presentation.ui.theme.gold

@Preview
@Composable
private fun RatingBarPreview() {
    StarRating(3.0)
}

@Composable
fun StarRating(rating: Double,modifier: Modifier=Modifier) {
    Row {
        for (i in 1..10) {
            Icon(
                imageVector = if (i <= rating.toInt()) Icons.Filled.Star else Icons.TwoTone.Star,
                contentDescription = null,
                tint = gold,
                modifier = modifier.size(dimensionResource(R.dimen.icon_size_large))
            )
        }
    }
}

