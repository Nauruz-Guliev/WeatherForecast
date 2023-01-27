package com.example.feature_forecast.domain.repository

import com.example.feature_forecast.domain.WeatherInfo
import com.example.feature_forecast.domain.utils.Status

interface WeatherRepository {
    suspend fun getWeeklyCityWeatherInfo(city: String): Status<List<WeatherInfo>>
    suspend fun getWeeklyCityWeatherInfo(lat: Double, lon: Double): Status<List<WeatherInfo>>
}