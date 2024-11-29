package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.presentation.ui.home.LoadingIndicator
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder


@Composable
fun FullScreenImageDialog(imageUrl: String?, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        FullScreenImageContent(imageUrl = imageUrl, onDismiss = onDismiss)
    }
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FullScreenImageContent(imageUrl: String?, onDismiss: () -> Unit,modifier: Modifier=Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        GlideImage(
            model = imageUrl,
            contentDescription = stringResource(id = R.string.property_image),
            modifier = modifier
                .fillMaxSize()
                .clickable { onDismiss() },
            contentScale = ContentScale.Fit,
            loading = placeholder {
                LoadingIndicator()
            },
            failure = placeholder(R.drawable.error),
        )
    }
}