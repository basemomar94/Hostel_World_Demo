package com.bassem.hostelworlddemo.presentation.ui.home

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.FreeCancellation
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.presentation.ui.theme.babyBlue
import com.bassem.hostelworlddemo.presentation.ui.theme.green
import com.bassem.hostelworlddemo.presentation.ui.theme.teal
import com.bassem.hostelworlddemo.presentation.ui.theme.yellow
import com.bassem.hostelworlddemo.presentation.utils.getPrice
import com.bassem.hostelworlddemo.presentation.utils.getRandomImageUrl
import com.bassem.hostelworlddemo.presentation.utils.getRating
import com.bassem.hostelworlddemo.utils.Logger

@Preview(showBackground = true)
@Composable
private fun PreviewPropertyItem() {
    PropertyItemCompose(
        name = "Sphinx Hotel",
        imageUrl = "",
        isFeatured = true,
        rating = 5.5,
        lowestPrice = "3.3",
        isNew = true,
        isPrompt = false,
        isFreeCancellation = false,
        onCardClick = {},
    )
}

@Composable
fun PropertyItem(property: Property, onCardClick: () -> Unit) {
    val log = Logger("PropertyItem")
    with(property) {
        log.d("random image url is ${imagesGallery.getRandomImageUrl()}")
        PropertyItemCompose(
            name = name,
            imageUrl = imagesGallery.getRandomImageUrl(),
            isFeatured = isFeatured,
            rating = ratingBreakdown.getRating(),
            lowestPrice = lowestPricePerNight.getPrice(),
            isNew = isNew,
            isPrompt = isPromoted,
            isFreeCancellation = freeCancellationAvailable,
            onCardClick = onCardClick,
        )
    }

}

@Composable
private fun PropertyItemCompose(
    name: String,
    imageUrl: String?,
    isFeatured: Boolean,
    isNew: Boolean,
    isPrompt: Boolean,
    isFreeCancellation: Boolean,
    onCardClick: () -> Unit,
    rating: Double,
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
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    when {
                        isFeatured -> FeaturedLabel(
                            modifier = modifier.align(Alignment.Top),
                            text = stringResource(R.string.featured),
                            backgroundColor = yellow
                        )

                        isNew -> FeaturedLabel(
                            modifier = modifier.align(Alignment.Top),
                            text = stringResource(R.string._new),
                            backgroundColor = babyBlue
                        )

                        isPrompt -> FeaturedLabel(
                            modifier = modifier.align(Alignment.Top),
                            text = stringResource(R.string.prompted),
                            backgroundColor = green
                        )

                        isFreeCancellation -> FeaturedLabel(
                            modifier = modifier.align(Alignment.Top),
                            text = stringResource(R.string.free_cancelation),
                            backgroundColor = teal
                        )


                    }
                }


            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.default_padding)))
            PropertyName(name)
            Row(
                modifier = modifier
                    .padding(dimensionResource(R.dimen.small_padding))
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                RatingLabel(
                    rating = rating,
                )
                PropertyLabelWithIcon(
                    text = lowestPrice,
                    drawable = R.drawable.price,
                    modifier = modifier.align(Alignment.CenterVertically)
                )

            }
        }
    }


}