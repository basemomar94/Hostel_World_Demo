package com.bassem.hostelworlddemo.presentation.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.bassem.hostelworlddemo.R

@Composable
fun DetailsContainer(overview: String, cancellation: String) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabTitles =
        listOf(stringResource(R.string.over_view), stringResource(R.string.cancelation))

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }
        when (selectedTabIndex) {
            0 -> DetailsText(overview)
            1 -> DetailsText(cancellation)
        }
    }
}
