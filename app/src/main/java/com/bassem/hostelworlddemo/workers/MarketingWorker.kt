package com.bassem.hostelworlddemo.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.bassem.hostelworlddemo.utils.Logger
import com.bassem.hostelworlddemo.utils.sendBackgroundNotification

/**
 * This worker to send marketing notifications to user every day
 */
class MarketingWorker(val context: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(context, workerParameters) {
    private val logger = Logger("MarketingWorker")

    override suspend fun doWork(): Result {
        context.sendBackgroundNotification()
        logger.i("sending from worker")
        return Result.success()
    }
}