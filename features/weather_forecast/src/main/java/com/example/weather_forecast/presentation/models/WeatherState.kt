package com.example.weather_forecast.presentation.models

import com.example.common.models.WeatherInfoModel

data class WeatherState(
    val weatherInfoModel: List<WeatherInfoModel>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)