package com.example.city_search_history.data

import com.example.city_search_history.data.entity.WeatherForecastEntity
import kotlinx.coroutines.flow.Flow

interface WeatherForecastRepository {
    suspend fun getWeatherForecastHistoryList() : Flow<List<WeatherForecastEntity>>

    suspend fun addWeatherForecastHistory(weatherForecast: WeatherForecastEntity)
}