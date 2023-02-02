package com.example.common.models

import java.util.*

data class WeatherInfoModel(
    val cityName: String,
    val day: Long,
    val weatherDescription: String,
    val iconId: String,
    val temperatureMorning: Double? = null,
    val temperatureDay: Double,
    val temperatureEvening: Double? = null,
    val humidity: Long? = null,
    val windSpeed: Double? = null,
    val pressure: Long? = null,
    val sunrise: Long,
    val sunset: Long,
    val searchDate: Date
)