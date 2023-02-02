package com.example.weather_forecast.data.remote

import com.example.weather_forecast.data.remote.dto.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    //todo make parameters editable in settings
    @GET("data/2.5/forecast/daily?&units=metric&cnt=7")
    suspend fun getForecastByCityName(@Query("q") city: String): ForecastResponse


    @GET("data/2.5/forecast/daily?&units=metric&cnt=7")
    suspend fun getForecastByCityCoordinates(
        @Query("lon") long: Double,
        @Query("lat") lat: Double,
    ): ForecastResponse
}