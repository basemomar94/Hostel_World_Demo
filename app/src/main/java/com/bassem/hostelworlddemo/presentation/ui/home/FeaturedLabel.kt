package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.presentation.ui.theme.gold

@Preview
@Composable
private fun FeaturedLabelPreview() {
    FeaturedLabel()
}

@Composable
fun FeaturedLabel(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = gold,
                shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius))
            )
            .padding(
                horizontal = dimensionResource(R.dimen.default_padding),
                vertical = dimensionResource(R.dimen.default_padding)
            )
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = stringResource(R.string.featured),
                tint = Color.White,
                modifier = modifier.size(dimensionResource(R.dimen.icon_size))
            )
            Spacer(modifier = modifier.width(dimensionResource(R.dimen.small_padding)))
            Text(
                text = "Featured",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}
