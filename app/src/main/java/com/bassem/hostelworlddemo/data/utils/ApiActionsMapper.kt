package com.bassem.hostelworlddemo.data.utils

import com.bassem.hostelworlddemo.data.utils.ApiConstants.ACTION_EXCHANGE_RATES
import com.bassem.hostelworlddemo.data.utils.ApiConstants.ACTION_PROPERTIES
import com.bassem.hostelworlddemo.data.utils.ApiConstants.EXCHANGE_END_POINT
import com.bassem.hostelworlddemo.data.utils.ApiConstants.PROPERTIES_END_POINT
import com.bassem.hostelworlddemo.data.utils.ApiConstants.UNKNOWN_ACTION

fun String.getActionName() = when  {
    this.contains(PROPERTIES_END_POINT) -> ACTION_PROPERTIES
    this.contains(EXCHANGE_END_POINT) -> ACTION_EXCHANGE_RATES
    else -> UNKNOWN_ACTION
}