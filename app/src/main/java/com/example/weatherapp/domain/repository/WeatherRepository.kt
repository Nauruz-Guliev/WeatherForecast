package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.WeatherInfo
import com.example.weatherapp.domain.utils.Status

interface WeatherRepository {
    suspend fun getWeeklyCityWeatherInfo(city: String): Status<List<WeatherInfo>>
}