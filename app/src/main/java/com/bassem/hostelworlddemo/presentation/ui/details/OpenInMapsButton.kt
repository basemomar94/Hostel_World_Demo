package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.presentation.utils.openInMap
import com.bassem.hostelworlddemo.utils.Logger


@Preview
@Composable
private fun OpenInMapsButtonPreview() {
    OpenInMapsButton(4.4, 3.3)
}

@Composable
fun OpenInMapsButton(latitude: Double?, longitude: Double?, modifier: Modifier = Modifier) {
    val logger = Logger("OpenInMapsButton")
    if (latitude != null && longitude != null) {
        val context = LocalContext.current
        Icon(
            tint = Color.Unspecified,
            painter = painterResource(id = R.drawable.map),
            contentDescription = stringResource(R.string.open_in_map),
            modifier = modifier.size(dimensionResource(R.dimen.icon_size_xlarge)).clickable {
                context.openInMap(latitude = latitude, longitude = longitude)
            }
        )
    } else {
        logger.e("lat or log is null")
    }
}
