package com.bassem.hostelworlddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.bassem.hostelworlddemo.presentation.ui.home.Navigation
import com.bassem.hostelworlddemo.presentation.ui.theme.HostelWorldDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HostelWorldDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar =
                    { TopAppBar(title = { Text(text = stringResource(R.string.hostel_world)) }) },
                ) { paddingValues ->
                    Navigation(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}