package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.models.WeatherInfoModel
import com.example.common.ui.theme.ui.FontColor


@Composable
internal fun TemperatureSection(weatherInfoModel: WeatherInfoModel) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(160.dp)
                .padding(
                    paddingValues =
                    PaddingValues(
                        top = 40.dp,
                        start = 40.dp,
                    )
                )
                .background(color = Color.Yellow, shape = RoundedCornerShape(64.dp))
        )
        Column(
            modifier = Modifier
                .padding(
                    paddingValues = PaddingValues(
                        top = 40.dp,
                        start = 16.dp
                    )
                )
                .weight(1.0f),

            ) {
            Text(
                text = weatherInfoModel.temperatureDay.toString() + "℃",
                fontSize = 48.sp,
                color = FontColor
            )
            Text(
                text = weatherInfoModel.cityName,
                fontSize = 20.sp,
                color = FontColor
            )
        }
    }
}