package com.kohendru.animecompose.network

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import timber.log.Timber

fun openMalUrl(malUrl: String, context: Context) {
    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(malUrl))
    try {
        context.startActivity(webIntent)
    } catch (e: ActivityNotFoundException) {
        Timber.e(e)
    }
}