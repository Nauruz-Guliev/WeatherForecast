package com.example.feature_forecast.presentation.models

import com.example.feature_forecast.domain.WeatherInfo

data class WeatherState(
    val weatherInfo: List<WeatherInfo>? = null ,
    val isLoading: Boolean = false,
    val error: String? = null
)