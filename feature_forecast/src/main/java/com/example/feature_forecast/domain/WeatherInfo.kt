package com.example.feature_forecast.domain

data class WeatherInfo(
    val cityName: String,
    val day: Int,
    val weatherDescription: String,
    val iconId: String,
    val temperatureMorning: Double,
    val temperatureDay: Double,
    val temperatureEvening: Double,
    val humidity: Int,
    val windSpeed: Double,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int
)