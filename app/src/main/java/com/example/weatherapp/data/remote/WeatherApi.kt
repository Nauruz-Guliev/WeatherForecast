package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.dto.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather?appid=56fc6c6cb76c0864b4cd055080568268&units=metric")
    suspend fun getCityWeather(@Query("q") city: String):WeatherResponse
}