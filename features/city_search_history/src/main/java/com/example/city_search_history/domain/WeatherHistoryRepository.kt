package com.example.city_search_history.domain

import com.example.city_search_history.data.entity.WeatherHistoryEntity
import com.example.city_search_history.domain.models.WeatherHistoryModel
import kotlinx.coroutines.flow.Flow

interface WeatherHistoryRepository {
    suspend fun getWeatherForecastHistoryList() : Flow<List<WeatherHistoryModel>>
    suspend fun addWeatherForecast(weatherHistoryModel: WeatherHistoryModel)
}