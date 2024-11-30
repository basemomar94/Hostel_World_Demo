package com.bassem.hostelworlddemo.presentation.ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bassem.hostelworlddemo.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder

@Preview(showBackground = true)
@Composable
private fun PropertyImagePreview() {
    PropertyImage(imageUrl = "test", modifier = Modifier)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PropertyImage(imageUrl: String?, modifier: Modifier) {
    GlideImage(
        model = imageUrl,
        contentDescription = stringResource(id = R.string.property_image),
        modifier = modifier,
        contentScale = ContentScale.Crop,
        loading = placeholder({
            LoadingIndicator()
        }),
        failure = placeholder(R.drawable.error),

        )
}