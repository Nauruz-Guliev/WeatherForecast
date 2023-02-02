package com.example.city_search_history.domain.useСases

import com.example.city_search_history.domain.WeatherHistoryRepository
import com.example.city_search_history.domain.models.WeatherHistoryModel
import javax.inject.Inject

class AddWeatherForecastUseCase @Inject constructor(
    private val weatherHistoryRepository: WeatherHistoryRepository
) {
    suspend operator fun invoke(
        weatherHistoryModel: WeatherHistoryModel
    ) = weatherHistoryRepository.addWeatherForecast(weatherHistoryModel = weatherHistoryModel)

}