package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.dto.ForecastResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather?appid=56fc6c6cb76c0864b4cd055080568268&units=metric")
    suspend fun getForecastByCityName(@Query("q") city: String): ForecastResponse


    @GET("data/2.5/weather?appid=56fc6c6cb76c0864b4cd055080568268&units=metric")
    suspend fun getForecastByCityCoordinates(
        @Query("lon") long: Double,
        @Query("lat") lat: Double,
    ): ForecastResponse
}