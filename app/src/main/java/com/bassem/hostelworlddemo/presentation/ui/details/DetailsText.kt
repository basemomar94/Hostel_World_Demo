package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R

@Preview
@Composable
private fun OverViewComposePreview() {


}

@Composable
fun DetailsText(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.default_padding))
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.small_padding)),
            style = MaterialTheme.typography.bodyMedium
        )
    }

}