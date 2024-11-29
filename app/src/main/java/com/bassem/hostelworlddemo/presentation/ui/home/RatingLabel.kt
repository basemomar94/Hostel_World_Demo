package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.presentation.ui.theme.green
import com.bassem.hostelworlddemo.presentation.ui.theme.red
import com.bassem.hostelworlddemo.presentation.ui.theme.yellow
import com.bassem.hostelworlddemo.presentation.utils.getRatingColor

@Preview
@Composable
private fun RatingLabelPreview() {
    RatingLabel(4.5)
}

@Composable
fun RatingLabel(rating: Double, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .clip(RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)))
            .background(getRatingColor(rating))
            .padding(
                horizontal = dimensionResource(R.dimen.small_padding),
                vertical = dimensionResource(R.dimen.small_padding)
            )
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Featured",
            tint = Color.White,
            modifier = modifier.size(dimensionResource(R.dimen.icon_size))
        )

        Spacer(modifier = modifier.width(dimensionResource(R.dimen.small_padding)))
        Text(
            text = "$rating",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}


