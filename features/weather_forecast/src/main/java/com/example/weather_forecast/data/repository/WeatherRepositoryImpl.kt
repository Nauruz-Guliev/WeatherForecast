package com.example.weather_forecast.data.repository

import com.example.common.models.WeatherInfoModel
import com.example.common.utility.GeneralWeatherState
import com.example.weather_forecast.data.mappers.WeatherMapper
import com.example.weather_forecast.data.remote.WeatherApi
import com.example.weather_forecast.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeeklyCityWeatherInfo(city: String): GeneralWeatherState<List<WeatherInfoModel>> {
        return try {
            GeneralWeatherState.Success(
                data = WeatherMapper
                    .toModel(
                        model = api.getForecastByCityName(city)
                    )
            )
        } catch (e: Exception) {
            GeneralWeatherState.Error(
                message = e.message ?: "Unknown error",
                data = null
            )
        }
    }

    override suspend fun getWeeklyCityWeatherInfo(
        lat: Double,
        lon: Double
    ): GeneralWeatherState<List<WeatherInfoModel>> {
        return try {
            GeneralWeatherState.Success(
                data = WeatherMapper
                    .toModel(
                        model = api.getForecastByCityCoordinates(
                            long = lon,
                            lat = lat,
                        )
                    )
            )
        } catch (e: Exception) {
            GeneralWeatherState.Error(
                message = e.message ?: "Unknown error",
                data = null
            )
        }
    }
}