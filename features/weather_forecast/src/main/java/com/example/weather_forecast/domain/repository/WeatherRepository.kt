package com.example.weather_forecast.domain.repository

import com.example.common.models.WeatherInfo
import com.example.weather_forecast.domain.utils.Status

interface WeatherRepository {
    suspend fun getWeeklyCityWeatherInfo(city: String): Status<List<WeatherInfo>>
    suspend fun getWeeklyCityWeatherInfo(lat: Double, lon: Double): Status<List<WeatherInfo>>
}