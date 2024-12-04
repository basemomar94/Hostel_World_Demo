package com.bassem.hostelworlddemo

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.bassem.hostelworlddemo.presentation.ui.shared.Navigation
import com.bassem.hostelworlddemo.presentation.ui.theme.HostelWorldDemoTheme
import com.bassem.hostelworlddemo.utils.Logger
import com.bassem.hostelworlddemo.utils.createNotificationChannel
import com.bassem.hostelworlddemo.utils.hasNotificationPermission
import com.bassem.hostelworlddemo.utils.scheduleDailyWork
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val logger = Logger("Notification")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (hasNotificationPermission()) {
            logger.i("App has notification permission")
            scheduleDailyWork()
            createNotificationChannel()
        } else {
            requestNotificationPermission()
        }

        enableEdgeToEdge()
        setContent {
            HostelWorldDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = { Text(text = stringResource(R.string.hostel_world)) })
                    },
                ) { paddingValues ->
                    Navigation(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                logger.i("Permission granted")
                scheduleDailyWork()
                createNotificationChannel()
            } else {
                logger.i("Permission denied")
            }
        }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
        }
    }

}
