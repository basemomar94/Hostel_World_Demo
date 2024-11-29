package com.bassem.hostelworlddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bassem.hostelworlddemo.presentation.ui.HostelWorldApp
import com.bassem.hostelworlddemo.presentation.ui.theme.HostelWorldDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HostelWorldDemoTheme {
                HostelWorldApp()
            }
        }
    }
}