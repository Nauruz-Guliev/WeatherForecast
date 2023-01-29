package com.example.weather_forecast.domain

data class WeatherInfo(
    val cityName: String,
    val day: Long,
    val weatherDescription: String,
    val iconId: String,
    val temperatureMorning: Double,
    val temperatureDay: Double,
    val temperatureEvening: Double,
    val humidity: Long,
    val windSpeed: Double,
    val pressure: Long,
    val sunrise: Long,
    val sunset: Long
)