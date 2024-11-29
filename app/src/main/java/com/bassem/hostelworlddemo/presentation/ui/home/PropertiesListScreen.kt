package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.presentation.viewmodels.HomeViewModel
import com.bassem.hostelworlddemo.data.models.Result
import com.bassem.hostelworlddemo.utils.Logger

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PropertiesListScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onClick: (Property) -> Unit
) {
    val logger = Logger("HomeScreen")
    val result by viewModel.propertiesList.collectAsState(initial = Result.Loading)



    Scaffold(
        topBar = { TopAppBar(title = { Text(text = stringResource(R.string.hostel_world)) }) },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            logger.i("breedResult is $result")

            when (result) {
                is Result.Loading -> LoadingIndicator()
                is Result.Success -> {

                    HomeList(
                        propertiesList = (result as Result.Success).propertiesData.properties,
                        onClick = onClick,
                    )
                }

                is Result.Fail -> {
                    ErrorTextCompose(message = (result as Result.Fail).reasons)
                }
            }
        }
    }
}
