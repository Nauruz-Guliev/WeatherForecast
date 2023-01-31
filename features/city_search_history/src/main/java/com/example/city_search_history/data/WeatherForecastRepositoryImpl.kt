package com.example.city_search_history.data

import com.example.city_search_history.data.dao.WeatherForecastDao
import com.example.city_search_history.data.entity.WeatherForecastEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherForecastRepositoryImpl @Inject constructor(
    private val weatherForecastDao: WeatherForecastDao
) : WeatherForecastRepository {
    override suspend fun getWeatherForecastHistoryList(): Flow<List<WeatherForecastEntity>>
    = weatherForecastDao.getAll()

    //todo mapper
    override suspend fun addWeatherForecastHistory(weatherForecast: WeatherForecastEntity) =
        weatherForecastDao.insert(weatherForecast)
}