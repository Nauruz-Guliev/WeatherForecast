package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.theme.ui.Primary

@Composable
internal fun DateSection(date: String) {
    Row(
        modifier = Modifier
            .background(Primary)
            .padding(
                paddingValues = PaddingValues(
                    top = 16.dp,
                    start = 16.dp,
                )
            )
    ) {
        Text(
            text = date,
            fontSize = 20.sp,
        )
    }
}