package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.data.models.Result
import com.bassem.hostelworlddemo.data.models.ResultData
import com.bassem.hostelworlddemo.presentation.ui.shared.ErrorTextCompose
import com.bassem.hostelworlddemo.presentation.ui.shared.LoadingIndicator
import com.bassem.hostelworlddemo.presentation.viewmodels.HomeViewModel
import com.bassem.hostelworlddemo.utils.Logger

@Composable
fun PropertiesListScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onClick: (Property) -> Unit,
    modifier: Modifier = Modifier
) {
    val logger = Logger("HomeScreen")
    val result by viewModel.propertiesList.collectAsState(initial = Result.Loading)

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        logger.i("breedResult is $result")

        when (result) {
            is Result.Loading -> {
                LoadingIndicator()
            }
            is Result.Success -> {
                val successResult = (result as Result.Success<Any?>).data as? ResultData
                if (successResult != null) {
                    val propertiesList = successResult.properties
                    if (propertiesList.isNotEmpty()) {
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

            is Result.Fail -> {
                ErrorTextCompose(message = (result as Result.Fail).reasons)
            }
        }
    }


}
