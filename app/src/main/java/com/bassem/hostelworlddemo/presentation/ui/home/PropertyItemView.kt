package com.bassem.hostelworlddemo.presentation.ui.home

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.presentation.utils.getImageUrl
import com.bassem.hostelworlddemo.utils.Logger

@Preview(showBackground = true)
@Composable
private fun PreviewPropertyItem() {
    PropertyItemCompose(
        name = "Sphinx Cat",
        imageUrl = "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg",
        isFeatured = true,
        rating = 5,
        lowestPrice = "3.3",
        onCardClick = {},
    )
}

@Composable
fun PropertyItem(property: Property, onCardClick: () -> Unit) {
    val log = Logger("PropertyItem")
    with(property) {
        log.d("random image url is ${imagesGallery.getImageUrl()}")
        PropertyItemCompose(
            name = name,
            imageUrl = imagesGallery.getImageUrl(),
            isFeatured = isFeatured,
            rating = ratingBreakdown.average,
            lowestPrice = lowestPricePerNight.value,
            onCardClick = onCardClick,
        )
    }

}

@Composable
private fun PropertyItemCompose(
    name: String,
    imageUrl: String?,
    isFeatured: Boolean,
    onCardClick: () -> Unit,
    rating: Int,
    lowestPrice: String,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onCardClick,
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.card_side_margin))
            .shadow(
                elevation = dimensionResource(
                    id = R.dimen.small_padding,
                ), shape = RoundedCornerShape(8.dp)
            )
    ) {
        Column(modifier = modifier.fillMaxWidth()) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                PropertyImage(
                    imageUrl = imageUrl, modifier = modifier
                        .fillMaxWidth()
                        .height(
                            dimensionResource(id = R.dimen.image_height)
                        )
                )
                if (isFeatured) {
                    FeaturedLabel(modifier = modifier.padding(dimensionResource(R.dimen.small_padding)))
                }

            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.default_padding)))
            PropertyName(name)
            Row(modifier = modifier.padding(dimensionResource(R.dimen.small_padding)).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                RatingLabel(
                    rating = rating,
                )
                PropertyPrice(lowestPrice = lowestPrice, modifier = modifier.align(Alignment.CenterVertically))

            }
        }
    }


}