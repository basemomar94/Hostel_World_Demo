package com.bassem.hostelworlddemo.presentation.ui.home

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.NavigableListDetailPaneScaffold
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bassem.hostelworlddemo.data.models.Property
import com.bassem.hostelworlddemo.presentation.ui.details.DetailsScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Any>()

    NavigableListDetailPaneScaffold(
        navigator = navigator,
        listPane = {
            AnimatedPane {
                PropertiesListScreen(modifier = modifier, onClick = { property ->
                    navigator.navigateTo(
                        pane = ListDetailPaneScaffoldRole.Detail,
                        content = property
                    )
                })
            }
        },
        detailPane = {
            AnimatedPane {
                navigator.currentDestination?.content?.let { property ->
                    DetailsScreen(property = property as Property, modifier)
                }
            }
        },
    )
}
