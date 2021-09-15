package com.kohendru.animecompose.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kohendru.animecompose.R

@Composable
fun MessageBox(
    modifier: Modifier = Modifier,
    @StringRes messageResId: Int
) {

    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = messageResId),
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.error
        )

    }
}