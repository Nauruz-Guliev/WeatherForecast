package com.example.city_search_history.domain.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

data class WeatherHistoryModel(
    val id: Int? = null,
    val cityName: String,
    val day: Long,
    val weatherDescription: String,
    val iconId: String,
    val temperature: Double,
    val sunrise: Long,
    val sunset: Long,
    val dateOfSearch: Date
)