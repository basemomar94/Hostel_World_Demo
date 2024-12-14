package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.data.models.PropertyResult
import com.bassem.hostelworlddemo.data.models.PropertiesResultData
import com.bassem.hostelworlddemo.presentation.ui.shared.ErrorTextCompose
import com.bassem.hostelworlddemo.presentation.ui.shared.LoadingIndicator
import com.bassem.hostelworlddemo.presentation.utils.getErrorMessage
import com.bassem.hostelworlddemo.presentation.viewmodels.HomeViewModel
import com.bassem.hostelworlddemo.utils.Logger

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onClick: (Property) -> Unit,
    modifier: Modifier = Modifier
) {
    Logger("HomeScreen")
    val propertyResult by viewModel.propertiesList.collectAsState(initial = PropertyResult.Loading)
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        when (propertyResult) {
            is PropertyResult.Loading -> {
                LoadingIndicator()
            }

            is PropertyResult.Success -> {
                val successPropertyResult =
                    (propertyResult as PropertyResult.Success<Any?>).data as? PropertiesResultData
                if (successPropertyResult != null) {
                    val propertiesList = successPropertyResult.properties
                    if (propertiesList.isNotEmpty()) {
                        val city = successPropertyResult.location?.city
                        if (city != null) {
                            CityCountryCard(city = city.name, country = city.country)
                        }
                        HomeList(
                            propertiesList = propertiesList,
                            onClick = onClick,
                        )
                    } else {
                        ErrorTextCompose(message = stringResource(R.string.no_properties_found))
                    }
                } else {
                    ErrorTextCompose(message = stringResource(R.string.unexpected_data_format))
                }
            }

            is PropertyResult.Fail -> {
                ErrorTextCompose(message = context.getErrorMessage((propertyResult as PropertyResult.Fail).errorTypes))
            }
        }
    }


}
