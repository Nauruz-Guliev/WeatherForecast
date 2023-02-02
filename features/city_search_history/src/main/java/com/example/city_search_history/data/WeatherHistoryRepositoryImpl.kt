package com.example.city_search_history.data

import com.example.city_search_history.data.dao.WeatherHistoryDao
import com.example.city_search_history.data.entity.mapper.WeatherHistoryEntityMapper
import com.example.city_search_history.domain.WeatherHistoryRepository
import com.example.city_search_history.domain.models.WeatherHistoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class WeatherHistoryRepositoryImpl @Inject constructor(
    private val weatherForecastDao: WeatherHistoryDao,
    private val dispatcher: CoroutineContext
) : WeatherHistoryRepository {
    override suspend fun getWeatherForecastHistoryList() =
        withContext(dispatcher) {
            weatherForecastDao.getAll().map { historyList ->
                historyList.map { entity ->
                    WeatherHistoryEntityMapper.toModel(
                        model = entity
                    )
                }
            }
        }
    override suspend fun addWeatherForecast(weatherHistoryModel: WeatherHistoryModel) =
        withContext(dispatcher) {
            weatherForecastDao.insert(
                WeatherHistoryEntityMapper.fromModel(
                    model = weatherHistoryModel
                )
            )
        }

}