package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R

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
                imageVector = if (i <= rating.toInt()) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                contentDescription = null,
                tint = Color.Yellow,
                modifier = modifier.size(dimensionResource(R.dimen.icon_size))
            )
        }
    }
}

