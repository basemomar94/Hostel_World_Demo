package com.bassem.hostelworlddemo.presentation.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideSubcomposition
import com.bumptech.glide.integration.compose.RequestState

@Preview(showBackground = true)
@Composable
private fun PropertyImagePreview() {
    PropertyImage(imageUrl = "test", modifier = Modifier)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PropertyImage(imageUrl: String?, modifier: Modifier) {
    GlideSubcomposition(
        model = imageUrl ?: R.drawable.error,
        modifier = modifier,
    ) {
        when (state) {
            is RequestState.Failure -> Image(painterResource(id = R.drawable.error), "failure")
            is RequestState.Loading -> LoadingIndicator()
            is RequestState.Success -> Image(
                painter,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
