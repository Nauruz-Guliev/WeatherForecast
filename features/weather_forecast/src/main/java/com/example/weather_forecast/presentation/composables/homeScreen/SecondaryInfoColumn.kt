package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
internal fun SecondaryWeatherInfoColumn(
    primaryText: String,
    secondaryText: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = primaryText,
            fontSize = 20.sp
        )
        Text(
            modifier = modifier.padding(2.dp),
            text = secondaryText,
            color = Color.Gray
        )
    }
}