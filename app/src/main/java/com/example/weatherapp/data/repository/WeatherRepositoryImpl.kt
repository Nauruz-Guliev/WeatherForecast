package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mappers.WeatherMapper
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.domain.WeatherInfo
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.utils.Status
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeeklyCityWeatherInfo(city: String): Status<List<WeatherInfo>> {
        return try {
            Status.Success(
                data = WeatherMapper
                    .weatherDtoToListOfWeatherInfo(
                        response = api.getCityWeather(city)
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