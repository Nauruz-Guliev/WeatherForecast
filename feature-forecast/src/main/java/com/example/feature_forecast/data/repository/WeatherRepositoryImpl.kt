package com.example.feature_forecast.data.repository

import com.example.feature_forecast.data.mappers.WeatherMapper
import com.example.feature_forecast.data.remote.WeatherApi
import com.example.feature_forecast.domain.WeatherInfo
import com.example.feature_forecast.domain.repository.WeatherRepository
import com.example.feature_forecast.domain.utils.Status
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeeklyCityWeatherInfo(city: String): Status<List<WeatherInfo>> {
        return try {
            Status.Success(
                data = WeatherMapper
                    .weatherDtoToListOfWeatherInfo(
                        response = api.getForecastByCityName(city)
                    )
            )
        } catch (e: Exception) {
            Status.Error(
                message = e.message ?: "Unknown error",
                data = null
            )
        }
    }
}