package com.example.weather_forecast.domain.repository

import com.example.common.models.WeatherInfoModel
import com.example.common.utility.GeneralWeatherState

interface WeatherRepository {
    suspend fun getWeeklyCityWeatherInfo(city: String): GeneralWeatherState<List<WeatherInfoModel>>
    suspend fun getWeeklyCityWeatherInfo(lat: Double, lon: Double): GeneralWeatherState<List<WeatherInfoModel>>
}