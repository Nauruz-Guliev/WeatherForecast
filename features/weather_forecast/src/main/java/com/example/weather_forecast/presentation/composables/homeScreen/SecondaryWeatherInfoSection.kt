package com.example.weather_forecast.presentation.composables.homeScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.models.WeatherInfoModel


@Composable
internal fun SecondaryWeatherInfoSection(weatherInfoModel: WeatherInfoModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                paddingValues = PaddingValues(
                    top = 24.dp,
                )
            )
    ) {
        val columnCommonModifier = Modifier
            .weight(1.0f)
            .height(48.dp)
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfoModel.windSpeed.toString() + "km/h",
            secondaryText = "Wind",
            modifier = columnCommonModifier
        )
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfoModel.humidity.toString() + "%",
            secondaryText = "Humidity",
            modifier = columnCommonModifier
        )
        SecondaryWeatherInfoColumn(
            primaryText = weatherInfoModel.temperatureEvening.toString() + "℃",
            secondaryText = "Feels like",
            modifier = columnCommonModifier
        )
    }

}
