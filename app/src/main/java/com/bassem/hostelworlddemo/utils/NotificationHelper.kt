package com.bassem.hostelworlddemo.utils

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.bassem.hostelworlddemo.R
import com.bassem.hostelworlddemo.workers.MarketingWorker
import java.util.concurrent.TimeUnit

fun Context.createNotificationChannel() {
    val channelId = getString(R.string.default_notification_channel_id)
    val channelName = getString(R.string.default_notification_channel_name)

    val notificationManager = getSystemService(NotificationManager::class.java)
    if (notificationManager != null) {
        val existingChannel = notificationManager.getNotificationChannel(channelId)
        if (existingChannel == null) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = "New apps Alert"
                enableVibration(true)
            }
            notificationManager.createNotificationChannel(channel)
        }
    }
}


@SuppressLint("MissingPermission", "NotificationPermission")
fun Context.sendBackgroundNotification() {
    val notification = NotificationCompat.Builder(
        this,
        getString(R.string.default_notification_channel_id)
    )
        .setSmallIcon(R.drawable.hotel_world)
        .setContentTitle(getString(R.string.notification_title))
        .setOnlyAlertOnce(true)
        .setOngoing(false)
        .setContentText(getString(R.string.notification_text))
        .setAutoCancel(false)
        .build()
    val notificationManger = NotificationManagerCompat.from(this)
    notificationManger.notify(1, notification)
}


fun Context.hasNotificationPermission(): Boolean {
    return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
        ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    } else {
        true
    }
}

fun Context.scheduleHourlyWork() {
    val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()
    val workRequest =
        PeriodicWorkRequestBuilder<MarketingWorker>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .build()
    val workManager = WorkManager.getInstance(this)
    workManager.enqueueUniquePeriodicWork(
        "MarketingWorker",
        ExistingPeriodicWorkPolicy.UPDATE,
        workRequest
    )
}