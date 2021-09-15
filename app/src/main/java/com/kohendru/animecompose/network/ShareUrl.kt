package com.kohendru.animecompose.network

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.kohendru.animecompose.R

fun shareUrl(url: String, context: Context){
    val i = Intent()

    i.action = Intent.ACTION_SEND
    i.type = "text/plain"
    i.putExtra(Intent.EXTRA_TEXT, url)
    context.startActivity(Intent.createChooser(i, R.string.send_to.toString()))
}