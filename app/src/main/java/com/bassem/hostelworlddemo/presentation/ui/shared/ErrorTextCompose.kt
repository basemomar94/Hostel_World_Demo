package com.bassem.hostelworlddemo.presentation.ui.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R

@Preview(showBackground = true)
@Composable
fun ErrorTextComposePreview() {
    ErrorTextCompose(message = "Test Error")
}

@Composable
fun ErrorTextCompose(message: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.default_padding)),
        contentAlignment = Alignment.Center
    ) {
        if (!message.isNullOrEmpty()) {
            Text(
                text = message,
                color = Color.Red,

                )
        }

    }

}