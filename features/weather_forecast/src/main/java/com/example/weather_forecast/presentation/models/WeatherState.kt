package com.example.weather_forecast.presentation.models

import com.example.common.models.WeatherInfo

data class WeatherState(
    val weatherInfo: List<WeatherInfo>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)