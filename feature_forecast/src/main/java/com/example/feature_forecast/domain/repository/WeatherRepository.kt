package com.example.feature_forecast.domain.repository

import com.example.feature_forecast.domain.WeatherInfo
import com.example.feature_forecast.domain.utils.Status

interface WeatherRepository {
    suspend fun getWeeklyCityWeatherInfo(city: String): Status<List<WeatherInfo>>
}